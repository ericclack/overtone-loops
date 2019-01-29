(ns overtone-loops.examples.long-loop
  "A longer loop with variation using on-next-bar to schedule"
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 250547))
(def snare (freesound2 270156))
(def hat (freesound2 96140))

;; We want to use amps between 0 and 1 in our lists
(amp-scale 1)

;; Our loops - all 4 beats to the bar
(defloop hats (4 1/2) hat   [0 1 0 1 0 1 0 1])

(defloop kicks1 4     kick    [1          1        0          0      ])
(defloop snares 4     snare   [0          0        1                 ])

(defloop kicks2 (4 1/4) kick  [1 0 0 0.6  1 0 0 0  0 0 0 0.6  1 0 0 0])
;; (kicks2 (metro))

(bpm 120)
(beats-in-bar 4)
  
;; Kicks all the way through (10 bars)
(at-bar 1
        (hats 10)
        )

;; Kicks + snares start at bar 2 and run for 4 bars
(at-bar 2
        (kicks1  4)
        (snares  4)
        )

;; New pattern at bar 6
(at-bar 6
        (kicks2  4)
        (snares  4)
        )

;; ------------

(comment
  (kicks1 (metro) 1)
)

;;(stop)

