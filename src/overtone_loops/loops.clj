(ns overtone-loops.loops
  "Simpler music loop syntax for Overtone, the programmable music toolkit"
  (:use [overtone.live])
  (:require [clojure.pprint :refer [pp pprint]]))

(def metro (metronome 128))

(defn bpm [b]
  (metro-bpm metro b))

(defn on-next-bar
  "Metro marker for the next bar, or n bars ahead"
  ([beats-per-bar] (on-next-bar beats-per-bar 1))
  ([beats-per-bar bars]
   (*
    (+ bars
       (quot (metro) beats-per-bar))
    beats-per-bar)))


(defmacro thunk
  "Wrap the body in a function, thereby delaying execution"
  [& body]
  `(fn [] ~@body))

(defn- map-odds
  "Apply fn to odd items only: 1st, 3rd, ..."
  [fn seq]
  (cond
    (empty? seq) '()
    :else (list* (fn (first seq))
                 (second seq)
                 (map-odds fn (rest (rest seq))))))

(defn- map-evens
  "Apply fn to even items only: 2nd, 4th, ..."
  [fn seq]
  (cond
    (empty? seq) '()
    :else (list* (first seq)
                 (fn (second seq))
                 (map-evens fn (rest (rest seq))))))

(defn- pairer
  "Pair up items from a sequence, e.g. beat playable pairs"
  [seq]
  (cond
    (empty? seq) '()
    :else (cons (list (first seq) (second seq))
                (pairer (rest (rest seq))))
    ))

;;(pairer '(1 2 3 4 5 6 7 8))
;; => ((1 2) (3 4) (5 6) (7 8))

(defn- play-bar-pairs
  "Play this bar on beat, given a list of pairs (offset playable)"
  [beat beat-playable-pairs]
  (defn- player [[in-beats playable]]
    (at (metro (+ beat in-beats)) (playable)))
  (doall (map player beat-playable-pairs)))

;; (play-bar-pairs (metro) (pairer (list 0 kick 1 kick 2 snare)))
;; (play-bar-pairs (metro) (pairer (list 0.5 hat 1.5 hat)))

(defn play-bar 
  "Play this bar on beat, given: offset playable offset playable ..."
  [beat & beats-and-playables]
  (play-bar-pairs beat (pairer beats-and-playables)))

;; (play-bar (metro) 0 kick 1 kick 1 snare 2 kick 3 kick 3 snare)

(defn next-loop-iter
  "Schedule fn for beat with specified bars left"
  [fn beat bars-left]
  (apply-by (metro beat) fn beat bars-left []))

(defmacro defloop0 
  "Wrap pairs of beats and playables into a loop"
  [name beats-in-bar & beats-and-playables]
  (let* [beat-sym (gensym "beat")
         bars-left-sym (gensym "bars-left-sym")]
    `(defn ~name
       "Play this loop, starting at beat, optionally for a number of bars"
       ([~beat-sym] (~name ~beat-sym -1))
       ([~beat-sym ~bars-left-sym]
        (play-bar ~beat-sym ~@beats-and-playables)
        (when (not (= 1 ~bars-left-sym)) 
          (next-loop-iter ~name
                    (+ ~beats-in-bar ~beat-sym)
                    (dec ~bars-left-sym)))))))

;; (defloop0 hats 4
;;           0.5 hat 1.5 hat 2.5 hat 3.5 hat)
;; then:
;; (hats (metro))
;; play for 16 bars:
;; (hats (metro) 16)

(defmacro defloop
  "Like defloop0 but pairs are beats and s-exps, which we wrap in a thunk so they don't all play immediately"
  [name beats-in-bar & beats-and-sexps]
  (defn- make-thunk [s-exp]
    `(thunk ~s-exp))
  (let [thunked-pairs (map-evens make-thunk beats-and-sexps)]
    `(defloop0 ~name ~beats-in-bar ~@thunked-pairs)))

;; (defloop hats 4 0.5 (hat :amp 1) 1.5 (hat :amp 0.8))
;; then:
;; (hats (metro))

(defmacro deflooplist
  [name beats-in-bar instr amps-list]
  (defn- make-instr-thunk [amp]
    `(thunk (~instr :amp ~amp)))
  (let [beats-amps (flatten (map-indexed #(list %1 %2) amps-list))
        thunked-pairs (map-evens make-instr-thunk beats-amps)]
    `(defloop0 ~name ~beats-in-bar ~@thunked-pairs)))

;; Example

(defmacro defphrase
  "Define a phrase with pairs of beats and s-exps, like defloop but with no looping"
  [name & beats-and-sexps]
  (defn- make-thunk [s-exp]
    `(thunk ~s-exp))
  (let [thunked-pairs (map-evens make-thunk beats-and-sexps)
        beat-sym (gensym "beat")]
    `(defn ~name
       [~beat-sym]
       (play-bar ~beat-sym ~@thunked-pairs))))

;; (defphrase part1 0 (hat) 2 (hat) 3 (hat))
;; then to play a repeat:
;; (part1 (metro))
;; (part1 (on-next-bar 4 2))

;; ---------------------------------------------------------------

(defsynth my-mono-sample-player
  "Play a mono sample"
  [buf-id 0 duration 1 amp 1 rate 1 release 0.01]
  (let [dur    (/ duration rate)
        env    (env-gen (lin 0.01
                             (- dur release 0.01)
                             release)
                        :action FREE)
        rate2  (* (buf-rate-scale buf-id) rate)
        snd    (play-buf 1 buf-id rate2)]
    (out 0 (* amp env snd))))

(defsynth my-stereo-sample-player
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
    (out 0 (* amp env snd))))

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
        (= 1 channels) (apply my-mono-sample-player buf-id dur args)
        (= 2 channels) (apply my-stereo-sample-player buf-id dur args)))))

;; (def f (freesound2 213904))
;; (f)
;; (f :amp 0.5)
;; (f :rate 2)

;;(stop)
