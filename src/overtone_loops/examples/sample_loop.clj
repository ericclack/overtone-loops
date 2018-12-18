(ns overtone-loops.sample-loop
  (:use [overtone.live])
  (:require [clojure.pprint :refer [pp pprint]]
            [overtone-loops.loops :refer [defloop metro]]))

;; Define some samples from Freesound.org
(def kick (freesound 250547))
(def snare (freesound 270156))
(def hat (freesound 96140))

;; Our loops - both 4 beats to the bar
(defloop player 4
  0 kick
  0.5 hat
  1 kick
  1.5 hat
  2 snare
  2.5 hat
  3.5 hat
  )

(metro-bpm metro 120)
(player (metro))

;;

;;(stop)

