(ns overtone-loops.examples.heart-beat
  "Simple defloop0 example heartbeat pattern"
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 250547))
(def hat (freesound2 96140))

;; Our loops - both 4 beats to the bar
(defloop0 heart 4
  0 kick
  1 kick
  )

(defloop0 ticks 4
  0 hat
  1 hat
  2 hat
  2.5 hat)

(metro-bpm metro 240)
(heart (metro))
(ticks (metro))
;;

;;(stop)

