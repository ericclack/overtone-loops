(ns overtone-loops.loops
  "Simpler music loop syntax for Overtone, the programmable 
  music toolkit."
  (:use [overtone.live])
  (:require [overtone-loops.utils :refer :all]
            [clojure.pprint :refer [pp pprint]]))

(def metro (metronome 128))
(def the-amp-scale (atom 1/9))
(def the-beats-in-bar (atom 4))
(def *loop-fn-counter* (atom 0))
(def *loop-patterns* (transient (hash-map)))

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
    (at (metro (+ beat (* in-beats beat-fraction)))
        (instrument (scale-amps amp))))
  (doall (map-indexed player params-list)))

(defn next-loop-iter
  "Schedule fn for beat any extra args."
  [fun beat & rest]
  (apply-by (metro beat) fun beat rest))

;; ----------------------------------------------------------------

(defn makeloop 
  "Wrap pairs of beats and playables into a loop
  
  ;; Examples
  (def hat (freesound2 404890))
  (def hats (makeloop 4
                      0.5 hat 1.5 hat 2.5 hat 3.5 hat)
  ;; then:
  (hats (metro))
  ;; play for 16 bars:
  (hats (metro) 16)
  "
  [beats-in-bar & beats-and-playables]
  (fn aloop  
    [beat & rest]
    (let [bars-left (if (number? (first rest))
                      (first rest) -1)
          beat-adjust (first (filter fn? rest))]
      (apply play-bar beat beat-adjust beats-and-playables)
      (when (not (= 1 bars-left)) 
        (next-loop-iter aloop
                        (+ beats-in-bar beat)
                        (dec bars-left)
                        beat-adjust)))))

(defmacro defloop0
  "A macro version of makeloop, but with the added
  advantage that you can redefine the loop while it is
  playing and hear the changes in real time. You do need
  to wait for a couple of repeats though..."
  
  [name beats-in-bar & beats-and-playables]
  (let* [beat-sym (gensym "beat")
         rest-sym (gensym "rest")
         bars-left-sym (gensym "bars-left-sym")
         beat-adjust-sym (gensym "beat-adjust-sym")]
    `(defn ~name
       [~beat-sym & ~rest-sym]
       
       (let [~bars-left-sym (if (number? (first ~rest-sym))
                              (first ~rest-sym) -1)
             ~beat-adjust-sym (first (filter fn? ~rest-sym))]
         
         (play-bar ~beat-sym ~beat-adjust-sym ~@beats-and-playables)
         (when (not (= 1 ~bars-left-sym)) 
           (next-loop-iter ~name
                           (+ ~beats-in-bar ~beat-sym)
                           (dec ~bars-left-sym)
                           ~beat-adjust-sym))))))
(defmacro defloop1
  "Like defloop0 but pairs are beats and s-exps, enabling 
  you to pass in parameters such as :amp. We wrap these 
  s-exps in a thunk so they don't all play immediately.

  ;; Examples
  (def hat (freesound2 404890))
  (defloop hats 4 
     0.5 (hat :amp 1) 1.5 (hat :amp 0.8))
  ;; then:
  (hats (metro))
  "
  [name beats-in-bar & beats-and-sexps]
  (defn- make-thunk [s-exp]
    `(thunk ~s-exp))
  (let [thunked-pairs (map-evens make-thunk beats-and-sexps)]
    `(defloop0 ~name ~beats-in-bar ~@thunked-pairs)))

(defmacro deflooplist
  "Define a loop for a single instrument with params list, in the 
  simplest case defining amplitudes on each beat.

  Amps are numbers 0 to 9, where 0 is silence and 9 is full volume.
  You can use - instead of 0. You can change this scale with the
  amp-scale function, e.g. if you prefer to use 0.0 to 1.0

  ;; Example
  (defloop hats   4 hat   [- 5 - 5 ])
  (defloop kicks  4 kick  [7 - 2 - ])
  ;; Or with fractional beats
  (defloop hats   (4 1/2) hat [- 5 - 5 - 5 - 5])

  To get more control, params can be vectors or lists to pass to your
  instrument, e.g. you could pass a note and amplitude for each beat.

  (defn k [anote amp]
    (ks1 (note anote) :amp (/ amp 9)))

  (deflooplist melody1 8 k [[:g4 8] [:a4 8] [:b4 8] [:c5 8]])
  "
  
  [name beat-pattern instr params-list]
  (let [beats-in-bar (if (list? beat-pattern) (first beat-pattern) beat-pattern)
        fraction (if (list? beat-pattern) (second beat-pattern) 1)
        true-params-list (->> params-list
                            (replace {'- 0} ,,,)
                            (map scale-amps ,,,))]
    (defn- make-instr-thunk [param]
      (cond
        (and (number? param) (zero? param))       `(thunk) ;; do nothing
        (number? param)                           `(thunk (~instr :amp ~param))
        (and (sequential? param) (empty? param))  `(thunk)
        (sequential? param)                       `(thunk (apply ~instr ~param))))

    (let [beats-params (apply concat (map-indexed #(list (* %1 fraction) %2)
                                                  true-params-list))
          thunked-pairs (map-evens make-instr-thunk beats-params)]
      `(defloop0 ~name ~beats-in-bar ~@thunked-pairs))))

(defmacro defloop
  "Uber defloop, picks the the macro based on parameters, 
  one of defloop1 or deflooplist:

  (defloop name beats-in-bar   beat (instr)  beat (instr)  ...)
  (defloop name beats-in-bar   intsr [amp amp amp ...])
  "
  [name beats-in-bar & rest]
  (cond
    ;; We assume a symbol represents an instrument function
    (symbol? (first rest)) `(deflooplist ~name ~beats-in-bar ~@rest)
    ;; A number followed by an s-exp
    (and
     (number? (first rest))
     (list? (second rest))) `(defloop1 ~name ~beats-in-bar ~@rest)
    ;; Something else
    :else (throw (Exception. (str "Invalid parameters, got: name, beats and " rest)))))

;; - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

(defn loop-player
  "Return a function to play this loop pattern. E.g.

  (def a (loop-player 4 snare [4 6 7 3]))

  Then:
  (a (metro))
  "
  [beats instrument pattern]
  
  (let [beats-in-bar (if (vector? beats) (first beats) beats)
        fraction (if (vector? beats) (second beats) 1)
        loop-fn-id (swap! *loop-fn-counter* inc)]
    (assoc! *loop-patterns* loop-fn-id pattern)
    
    (fn player [beat & rest]
      (let [this-fn-id loop-fn-id
            pattern (get *loop-patterns* this-fn-id)]
        (if (some? rest)
          (assoc! *loop-patterns* this-fn-id (first rest))
          (do  
            (play-bar-list beat fraction instrument pattern)
            (next-loop-iter player (+ beats-in-bar beat)))))))
  )

                      
;; - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 

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
