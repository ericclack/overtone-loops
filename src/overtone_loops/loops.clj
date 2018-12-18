(ns overtone-loops.loops
  (:use [overtone.live])
  (:require [clojure.pprint :refer [pp pprint]]))

(def metro (metronome 128))

(defmacro thunk [& body]
  `(fn [] ~@body))

(defn pairer
  "Pair up items from a sequence, e.g. beat playable pairs"
  [seq]
  (cond
    (empty? seq) '()
    :else (cons (list (first seq) (second seq))
                (pairer (rest (rest seq))))
    ))

;;(pairer '(1 2 3 4 5 6 7 8))
;; => ((1 2) (3 4) (5 6) (7 8))

(defn play-bar-pairs
  "Play this bar on beat, given a list of pairs (offset playable)"
  [beat beat-playable-pairs]
  (defn- player [[in-beats playable]]
    (at (metro (+ beat in-beats)) (playable)))
  (doall (map player beat-playable-pairs)))

;; (play-bar-pairs (metro) (pairer (list 0 kick 1 kick 2 snare)))
;; (play-bar-pairs (metro) (pairer (list 0.5 hat 1.5 hat)))

(defn play-bar [beat & beats-and-playables]
  "Play this bar on beat, given: offset playable offset playable ..."
  (play-bar-pairs beat (pairer beats-and-playables)))

;; (play-bar (metro) 0 kick 1 kick 1 snare 2 kick 3 kick 3 snare)

(defn next-bar [fn beat bars-left]
  "Call this function on beat"
  (apply-by (metro beat) fn beat bars-left []))

(defmacro defloop [name beats-in-bar & beats-and-playables]
  "Wrap pairs of beats and playables into a loop"
  (let [beat-sym (gensym "beat")
        bars-left-sym (gensym "bars-left-sym")]
    `(defn ~name
       "Play this loop, starting at beat, optionally for a number of bars"
       ([~beat-sym] (~name ~beat-sym -1))
       ([~beat-sym ~bars-left-sym]
        (play-bar ~beat-sym ~@beats-and-playables)
        (when (not (= 0 ~bars-left-sym)) 
          (next-bar ~name (+ ~beats-in-bar ~beat-sym) (dec ~bars-left-sym)))))))

;; (defloop hats 4
;;          0.5 hat 1.5 hat 2.5 hat 3.5 hat)
;; then:
;; (hats (metro))
;; play for 16 bars:
;; (hats (metro) 16)

(defn add-instr [instr seq]
  "From the sequence of pairs (beat options) generate (beat (instrument options))"
  (cond
    (empty? seq) '()
    :else (cons (first seq)
                (cons (thunk (apply instr (second seq)))
                      (add-instr instr (rest (rest seq)))))))

;;(stop)
