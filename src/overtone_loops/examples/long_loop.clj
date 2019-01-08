(ns overtone-loops.examples.long-loop
  "A longer loop with variation using on-next-bar to schedule"
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 250547))
(def snare (freesound2 270156))
(def hat (freesound2 96140))

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
  
;; Kicks all the way through
(hats (metro))

;; Kicks start at bar 2 and run for 4 bars
(kicks1 (on-next-bar 4 2) 4)

;; New pattern at bar 6
(kicks2 (on-next-bar 4 6) 4)


;; ------------

(comment
  (kicks1 (metro) 1)
)

;;(stop)

