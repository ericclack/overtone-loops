(ns overtone-loops.examples.new-style-loop
  "Same pattern as old_style but using defloop0"
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 250547))
(def snare (freesound2 270156))
(def hat (freesound2 96140))

;; Our loops - both 4 beats to the bar
(defloop0 player 4
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

;;(stop)

