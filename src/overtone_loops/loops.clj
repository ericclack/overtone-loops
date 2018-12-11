(ns overtone-loops.loops
  (:use [overtone.live])
  (:require [clojure.pprint :refer [pp pprint]]))

(def metro (metronome 128))

(defn pairer
  "Pair up items from a sequence, e.g. beat sample pairs"
  [seq]
  (cond
    (empty? seq) '()
    :else (cons (list (first seq) (second seq))
                (pairer (rest (rest seq))))
    ))

;;(pairer '(1 2 3 4 5 6 7 8))
;; => ((1 2) (3 4) (5 6) (7 8))

(defn play-bar-pairs
  "Play this bar on beat, given pairs of (offset sample)"
  [beat beat-sample-pairs]
  (defn- player [[in-beats sample]]
    (at (metro (+ beat in-beats)) (sample)))
  (doall (map player beat-sample-pairs)))

;; (play-bar-pairs (metro) (pairer (list 0 kick 1 kick 2 snare)))
;; (play-bar-pairs (metro) (pairer (list 0.5 hat 1.5 hat)))

(defn play-bar [beat & beats-and-samples]
  "Play this bar on beat, given list of: offset sample offset sample ..."
  (play-bar-pairs beat (pairer beats-and-samples)))

;; (play-bar (metro) 0 kick 1 kick 1 snare 2 kick 3 kick 3 snare)

(defn next-bar [fn beat]
  "Call this function on beat"
  (apply-by (metro beat) fn beat []))

(defmacro defloop [name beats-in-bar & beats-and-samples]
  "Wrap pairs of beats and samples into a loop"
  (let [beat-sym (gensym "beat")]
    `(defn ~name [~beat-sym]
       (play-bar ~beat-sym ~@beats-and-samples)
       (next-bar ~name (+ ~beats-in-bar ~beat-sym)))))

;;(defloop kicks 2  0 kick 1 kick 1 snare)
;;(kicks (metro))

;;(stop)
