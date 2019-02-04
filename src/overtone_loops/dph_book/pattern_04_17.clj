(ns overtone-loops.dph-book.pattern-04-17
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def open-hh (freesound2 404893))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

(def ride (freesound2 162311)) ;; (ride)
(def ride-bell (freesound2 171482)) ;; (ride-bell)

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
(defloop ridebells (16 1/4) ride-bell [5 - - - 5 - - - - - - - - - - -  5 - - - 5 - - 3 6 5 - - 7 4 2 -  5 - - - 5 - - - - - - - - - - -  - - 5 - - - 5 - - - 5 - - - 5 - ])
(defloop rides     (16 1/4) ride      [- - 4 - - - 5 - - - 4 - - - 3 -  - - 4 - - - 3 - - - 4 - - - 7 6  - - 4 - - - 3 - 7 3 4 - 6 3 4 -  4 5 - - 4 5 - - 4 5 - - 4 5 - - ])

(defloop sds       (16 1/4) snare     [- - - - 7 - - - - 5 - - 7 - - -  - 5 - - 7 - 6 - - - - - 7 - - -  - - - - 7 - - 5 - - - - 7 - - -  - - - - 7 - - - - 5 - - 7 - - - ])
(defloop kicks     (16 1/4) kick      [6 - - 6 - - - 6 - - 7 - - - - -  7 - 6 7 - - - 7 6 - - - - - - 5  6 - 7 - - - 7 - - - 7 - - 7 - -  8 - 7 - - 7 - 7 8 - 7 8 - 7 - 6 ])
;;                                     |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 120)
(beats-in-bar 4)

(at-bar 1
        (ridebells)
        (rides)
        )

(at-bar 5
        (sds)
        (kicks)
        )

;;(stop)
