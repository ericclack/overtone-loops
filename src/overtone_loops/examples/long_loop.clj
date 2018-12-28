(ns overtone-loops.sample-loop
  (:use [overtone.live])
  (:require [clojure.pprint :refer [pp pprint]]
            [overtone-loops.loops :refer [defloop0 metro]]))

;; Define some samples from Freesound.org
(def kick (freesound 250547))
(def snare (freesound 270156))
(def hat (freesound 96140))

;; Our loops - all 4 beats to the bar
(defloop0 hats 4
  0.5 hat
  1.5 hat
  2.5 hat
  3.5 hat
  )

(defloop0 kicks1 4
  0 kick
  1 kick
  2 snare
  )

(defloop0 kicks2 4
  0 kick
  0.8 kick
  1 kick
  2 snare
  3 kick)

(metro-bpm metro 120)
  
(defn in-bars [bars beats-per-bar]
  (+ (* bars beats-per-bar) (metro)))

;; Kicks all the way through
(hats (metro))

;; Kicks start at bar 2 and run for 4 bars
(kicks1 (in-bars 2 4) 4)

;; New pattern at bar 6
(kicks2 (in-bars 6 4) 4)


;; ------------

(comment
  (kicks1 (metro) 1)
)

;;(stop)

