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

(defn schedule-ahead
  "Schedule loop playback generation a bit early to avoid playback glitches.
  Generation is early but beats are always ontime thanks to `apply-by` and `at`"
  [beat]
  (- beat 1/16))

(defn schedule-ahead-pattern
  "Schedule loop pattern changes a bit before loop playback  generation"
  [beat]
  (schedule-ahead (- beat 1/16)))

(defn play-phrase
  "Play this phrase expressed as a list of amplitudes or data to
  pass to instrument. 

  Examples:
  (play-phrase (metro) 1 kick   [6   1   5   6])
  (play-phrase (metro) 1/2 kick [6 _ 5 _ _ 4 6])
  "
  [beat beat-fraction instrument params-list]
  (doall (map-indexed
          (fn [in-beats amp]
            (when-not (and (number? amp) (zero? amp))
              (at (metro (+ beat (* in-beats beat-fraction)))
                  (instrument (scale-amps amp)))))
          params-list))
  nil)

(defn play-schedule-pairs
  "Play this bar on beat, given a list of pairs (offset playable)

  (play-bar-pairs (metro) [[0 kick] [1 kick] [2 snare]])
  (play-bar-pairs (metro) [[0.5 hat] [1.5 hat]])
  "
  [beat beat-playable-pairs]
  (doall (map (fn [[in-beats playable]]
                (at (metro (+ beat in-beats))
                    (playable)))
              beat-playable-pairs)))

(defn play-schedule
  "Play this combination of beats and playables. Easier to use than
  play-schedule-pairs, which does the work.

  (play-schedule (metro) 0 kick 1 kick 1 snare 2 kick 3 kick 3 snare)
  "
  [beat & beats-and-playables]
  (play-schedule-pairs beat (pairer beats-and-playables)))


;; ----------------------------------------------------------------

(defn set-up []
  (stop)
  (reset! loop-patterns (hash-map))
  (reset! loop-fn-counter 0))

(defn loop-player
  "Return a function to play this loop pattern. E.g.

  (def a (loop-player 4 snare [4 6 7 3]))

  Then:
  (a (metro))
  "
  [fraction instrument start-pattern]
  
  (let [loop-fn-id (swap! loop-fn-counter inc)]
    
    ;; Each function ID maps to a pattern
    (swap! loop-patterns
           assoc loop-fn-id [start-pattern])
    
    ;; Play this loop pattern on beat, or if specified change
    ;; this pattern on beat
    (with-meta
      (fn player
        [beat & rest]
        (let [new-pattern (when (some? rest) (first rest))]
          (if (some? new-pattern)
            ;; Just before beat, and just before next loop iteration, change the pattern
            (apply-by (metro (schedule-ahead-pattern beat))
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
              (apply-by (metro (schedule-ahead beat))
                        (fn []
                          (let [pattern (last (get @loop-patterns loop-fn-id))
                                beats-in-phrase (* (count pattern) fraction)]
                            (when (seq pattern)
                              (play-phrase beat fraction instrument pattern))
                            ;; Schedule the next loop and handle special case
                            ;; of empty pattern
                            (player
                             (if (empty? pattern)
                               (+ @the-beats-in-bar beat)
                               (+ beats-in-phrase beat))))))
              ))))
      {:doc (str "Player " loop-fn-id " for instrument " (:doc (meta instrument)) " with fraction " fraction)})
    ))

(defn silence
  "Send each loop player an empty list to silence it"
  [beat & fns]
  (doall (map #(% beat []) fns)))

;; - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

(defmacro defloop
  "Define a loop from a list of amplitudes."
  [name fraction instrument amps-list]
  `(def ~name
     (loop-player ~fraction ~instrument ~amps-list)))

(defmacro defschedule
  "Define a schedule of beats and playables with pairs of beats and s-exps.

  (defschedule part1 
     0 (piano :c3) 
     2 (piano :e3) 
     3 (piano :g3))

  ;; Then to play:
  (part1 (metro))

  ;; Or
  (at-bar 1 (part1))
  "
  [name & beats-and-sexps]
  (defn- make-thunk [s-exp]
    `(thunk ~s-exp))
  (let [thunked-pairs (map-evens make-thunk beats-and-sexps)
        beat-sym (gensym "beat")]
    `(defn ~name
       [~beat-sym]
       (play-schedule ~beat-sym ~@thunked-pairs))))

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
    (with-meta
      (fn [ & args ]
        (cond
          (= 1 channels) (apply mono-sample-player buf-id dur args)
          (= 2 channels) (apply stereo-sample-player buf-id dur args)))
      {:doc (str "Sample player for " path)})))

;;(stop)
