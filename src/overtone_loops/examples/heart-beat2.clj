(ns overtone-loops.heart-beat
  (:use [overtone.live])
  (:require [overtone-loops.loops :refer [defloop2 metro]]))

;; Define some samples from Freesound.org
(def kick (freesound 250547))
(def hat (freesound 96140))

;; Our loops - both 4 beats to the bar
(defloop2 heart 4
  0    (kick)
  1    (kick)
  2.5  (kick :amp 0.3)
  2.75 (kick :amp 0.5)
  3    (kick)
  )

(defloop2 ticks 4
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
