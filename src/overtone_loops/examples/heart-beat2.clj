(ns overtone-loops.examples.heart-beat2
  "Heart beat pattern using defloop, giving us more control"
  (:use [overtone.live])
  (:require [overtone-loops.loops :refer [defloop metro]]))

;; Define some samples from Freesound.org
(def kick (freesound 250547))
(def hat (freesound 96140))

;; Our loops - both 4 beats to the bar
(defloop heart 4
  0    (kick)
  1    (kick)
  2.5  (kick :amp 0.3)
  2.75 (kick :amp 0.5)
  3    (kick)
  )

(defloop ticks 4
  0    (hat)
  1    (hat)
  1.44 (hat :amp 0.4)
  1.88 (hat :amp 0.4)
  2    (hat)
  3    (hat)
  3.5  (hat :amp 0.5)
  )

(metro-bpm metro 240)
(heart (metro))
(ticks (metro))

;;(stop)
