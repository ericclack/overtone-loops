(ns overtone-loops.loops
  "Simpler music loop syntax for Overtone, the programmable 
  music toolkit."
  (:use [overtone.live])
  (:require [overtone-loops.utils :refer :all]
            [clojure.pprint :refer [pp pprint]]))

(def metro (metronome 128))
(def the-amp-scale (atom 1/9))
(def the-beats-in-bar (atom 4))
(def loop-fn-counter (atom 0))
(def loop-patterns (atom (hash-map)))

;; Make patterns easier to read
(def _ 0)

;; Schedule loop patterns a bit early to avoid playback glitches
(def schedule-ahead 1/10)

(defn bpm [b]
  (metro-bpm metro b))

(defn half-beat? [b]
  (and (ratio? b)
       (= (denominator b) 2)))

(defn quarter-beat? [b]
  (and (ratio? b)
       (= (denominator b) 4)))

(defn amp-scale [a]
  (reset! the-amp-scale a))

(defn scale-amps [a]
  "If a is just a number, scale it, otherwise preserve it."
  (if (number? a)
    (* a @the-amp-scale)
    a))

(defn beats-in-bar [b]
  (reset! the-beats-in-bar b))

;; -

(defn on-next-bar
  "Metro marker for the next bar, or n bars ahead"
  ([] (on-next-bar 1))
  ([bars]
   (*
    (+ bars
       (quot (metro) @the-beats-in-bar))
    @the-beats-in-bar)))

(defn play-bar-pairs
  "Play this bar on beat, given a list of pairs (offset playable)

  (play-bar-pairs (metro) [[0 kick] [1 kick] [2 snare]])
  (play-bar-pairs (metro) [[0.5 hat] [1.5 hat]])
  "
  [beat beat-playable-pairs]
  (defn- player [[in-beats playable]]
    (at (metro (+ beat in-beats)) (playable)))
  (doall (map player beat-playable-pairs)))

(defn play-bar 
  "Play this bar on beat, given: offset playable offset playable ...

  (play-bar (metro) 0 kick 1 kick 1 snare 2 kick 3 kick 3 snare)
  "
  [beat beat-adjust & beats-and-playables]
  (play-bar-pairs beat (pairer
                        (if (nil? beat-adjust)
                          beats-and-playables
                          (map-odds beat-adjust
                                    beats-and-playables)))))

(defn play-bar-list
  "Examples:
  (play-bar-list (metro) 1 kick   [6   1   5   6])
  (play-bar-list (metro) 1/2 kick [6 _ 5 _ _ 4 6])
  "
  [beat beat-fraction instrument params-list]
  (defn- player [in-beats amp]
    (when-not (and (number? amp) (zero? amp))
      (at (metro (+ beat (* in-beats beat-fraction)))
        (instrument (scale-amps amp)))))
  (doall (map-indexed player params-list)))

(defn next-loop-iter
  "Schedule fn for beat any extra args."
  [fun beat & rest]
  (apply-by (metro beat) fun beat rest))

;; ----------------------------------------------------------------

(defn set-up []
  (stop)
  (reset! loop-patterns (hash-map)))

(defn loop-player
  "Return a function to play this loop pattern. E.g.

  (def a (loop-player 4 snare [4 6 7 3]))

  Then:
  (a (metro))
  "
  [fraction instrument start-pattern]
  
  (let [loop-fn-id (swap! loop-fn-counter inc)]
    
    (print (str "Saving pattern for id " loop-fn-id ": " start-pattern "\n"))
    ;; Each function ID maps to a pattern
    (swap! loop-patterns
           assoc loop-fn-id [start-pattern])
    
    ;; Play this loop pattern on beat, or if specified change
    ;; this pattern on beat
    (fn player
      [beat & rest]
      (let [new-pattern (when (some? rest) (first rest))]
        (if (some? new-pattern)
          ;; On beat change the pattern
          (apply-by (metro beat)
                    (fn []
                      (condp = new-pattern
                        ;; Drop the most recent pattern
                        :pop (swap! loop-patterns
                                    update-in [loop-fn-id] pop)
                        ;; Back to the first pattern
                        :first (swap! loop-patterns
                                      update-in [loop-fn-id] #(vector (first %)))
                        ;; Put this new pattern at the head of the pattern list
                        (swap! loop-patterns
                               update-in [loop-fn-id] conj new-pattern))))
          (do
            ;; On beat get the pattern and play it
            (apply-by (metro (- beat schedule-ahead))
                      (fn []
                        (let [pattern (last (get @loop-patterns loop-fn-id))
                              beats-in-phrase (* (count pattern) fraction)]
                          (print (str "Playing pattern " pattern " on beat " beat "\n"))
                          (play-bar-list beat fraction instrument pattern)
                          (next-loop-iter player (+ beats-in-phrase beat))))))))))
  )

;; - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

(defmacro defloop
  [name fraction instrument amps-list]
  `(def ~name
     (loop-player ~fraction ~instrument ~amps-list)))

(defmacro defphrase
  "Define a phrase with pairs of beats and s-exps, like 
   defloop but with no looping.

  (defphrase part1 
     0 (piano :c3) 2 (piano :e3) 3 (piano :g3))
  ;; then to play a repeat:
  (part1 (metro))
  (part1 (on-next-bar 2))
  "
  [name & beats-and-sexps]
  (defn- make-thunk [s-exp]
    `(thunk ~s-exp))
  (let [thunked-pairs (map-evens make-thunk beats-and-sexps)
        beat-sym (gensym "beat")]
    `(defn ~name
       [~beat-sym]
       (play-bar ~beat-sym nil ~@thunked-pairs))))

(defmacro emptyloop
  "(Re)define a loop as an empty loop. You can redefine
  it again later to bring back beats as it is still
  actively looping.
  "
  [name beats-in-bar]
  `(defloop0 ~name ~beats-in-bar)
  )
  

;; - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

(defmacro at-bar
  "Schedule a list of loops to start on this bar by inserting the 
  correct metro marker as the first argument to each loop function.

  E.g. 
  (at-bar 11
          (snares 2)
          (kicks  2))
  Results in:
  (snares (on-next-bar 11) 2)
  (kicks (on-next-bar 11) 2)
  "
  [bar & loop-fns]
  (let [metro-marker (on-next-bar bar)]
    (defn- insert-metro [loop-s-exp]
      (let [fn (first loop-s-exp)
            rest (rest loop-s-exp)]
        `(~fn ~metro-marker ~@rest)))
    (let [timed-loop-fns (map insert-metro loop-fns)]
      `(do ~@timed-loop-fns))))

;; ---------------------------------------------------------------
;; Click-free sample players

(definst mono-sample-player
  "Play a mono sample"
  [buf-id 0 duration 1 amp 1 rate 1 release 0.01]
  (let [dur    (/ duration rate)
        env    (env-gen (lin 0.01
                             (- dur release 0.01)
                             release)
                        :action FREE)
        rate2  (* (buf-rate-scale buf-id) rate)
        snd    (play-buf 1 buf-id rate2)]
    (* amp env snd)))

(definst stereo-sample-player
  "Play a stereo sample, a separate synth because of
  limitations of passing ints through to play-buf"
  [buf-id 0 duration 1 amp 1 rate 1 release 0.01]
  (let [dur    (/ duration rate)
        env    (env-gen (lin 0.01
                             (- dur release 0.01)
                             release)
                        :action FREE)
        rate2  (* (buf-rate-scale buf-id) rate)
        snd    (play-buf 2 buf-id rate2)]
    (* amp env snd)))

(defn freesound2
  "Load and return a player for this freesound sample
  which takes arguments: amp rate release.

  A simpler form of the overtone freesound function, without 
  clicks and loops."
  [id]
  (let [sample-buf (load-sample (freesound-path id))
        buf-id     (:id sample-buf)
        dur        (:duration sample-buf)
        channels   (:n-channels sample-buf)]
    (fn [ & args ]
      (cond
        (= 1 channels) (apply mono-sample-player buf-id dur args)
        (= 2 channels) (apply stereo-sample-player buf-id dur args)))))

;; (def f (freesound2 213904))
;; (f)
;; (f :amp 0.5)
;; (f :rate 2)

(defn sample2
  "Load and return a player for the sample in a local file. 
  Plays click free."
  [path]
  (let [sample-buf (load-sample path)
        buf-id     (:id sample-buf)
        dur        (:duration sample-buf)
        channels   (:n-channels sample-buf)]
    (fn [ & args ]
      (cond
        (= 1 channels) (apply mono-sample-player buf-id dur args)
        (= 2 channels) (apply stereo-sample-player buf-id dur args)))))

;;(stop)
