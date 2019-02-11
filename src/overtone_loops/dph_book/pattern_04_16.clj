(ns overtone-loops.dph-book.pattern-04-16
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def open-hh (freesound2 404893))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                    BAR1                              BAR2                                BAR3                                BAR3
;;                    1 e & a 2 e & a 3 e & a 4 e & a   1 e & a 2 e & a 3 e & a 4 e & a   1 e & a 2 e & a 3 e & a 4 e & a   1 e & a 2 e & a 3 e & a 4 e & a  
(defloop open-hhs
  (16 1/4) open-hh   [- - - - - - - 7 - - - - - - - -   - - 7 - - - - - - - - - - 7 - -   - - - 7 - - - - - - 7 - - - - -   - - 7 - - - - 7 - - - - - - - -  ])
(defloop closed-hhs
  (16 1/4) closed-hh [5 3 7 5 5 4 8 - 5 3 6 5 4 4 8 5   4 3 - - 4 5 6 5 4 4 8 6 4 - 8 6   5 3 8 - 5 4 8 4 6 4 - - 4 3 8 6   5 4 - - 5 7 8 - 6 5 8 7 4 4 6 5  ])

(defloop sds
  (16 1/4) snare     [- - - - 8 - - - - 6 - - 8 - - -   - - - - 8 - - - - - - - 8 - - 6   - - - - 8 - - - - 6 - - 8 - - -   - - - - 8 - - - - - - - 8 - - 6  ])
(defloop kicks
  (16 1/4) kick      [7 - - 7 - - - 7 - - 8 - - - - -   7 - - - - - - 7 8 - 8 - - - 7 -   7 - - 6 - - - 7 - - 7 - - - - -   7 - - - - - - 6 7 - 7 - - - 7 -  ])

;; ---------------------------------------------

(bpm 86)
(beats-in-bar 4)

(at-bar 1
        (sds)
        (kicks)
        (closed-hhs)
        (open-hhs)
        )

;;(stop)