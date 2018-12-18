(ns overtone-loops.heart-beat
  (:use [overtone.live])
  (:require [overtone-loops.loops :refer [defloop metro]]))

;; Define some samples from Freesound.org
(def kick (freesound 250547))
(def hat (freesound 96140))

;; Our loops - both 4 beats to the bar
(defloop heart 4
  0 kick
  1 kick
  )

(defloop ticks 4
  0 hat
  1 hat
  2 hat
  2.5 hat)

(metro-bpm metro 240)
(heart (metro))
(ticks (metro))
;;

;;(stop)


