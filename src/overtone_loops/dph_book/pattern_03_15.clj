(ns overtone-loops.dph-book.pattern-03-15
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def open-hh (freesound2 404893))
(def ride-bell (freesound2 171482))
(def pedal-hh (freesound2 93910))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
;;                                     |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
(defloop rides      (8 1/4) ride-bell [- - 5 - - - 5 - - - 5 - - - 5 -  - - 5 - - 1 5 - - - 5 1 3 - 5 - ])
(defloop hats       (8 1/4) pedal-hh  [7 - - - 7 - - - 7 - - - 7 - - -  7 1 - - 7 - 5 - 7 1 - - 7 - - - ])

(defloop sds        (16 1/4) snare    [- - - - 7 - - - - 5 - - 7 - - -  - - - - 7 - - - - - - - 7 - - 5  - 5 - - 7 - 6 - - - - - 7 - - -  - - - - 7 - - - - 5 - - 7 - - - ])
(defloop kicks      (16 1/4) kick     [6 - - 6 - - - 6 - - 7 - - - - -  6 - - - - - - 5 6 - 7 - - - 7 -  7 - 6 7 - - - 7 - - 7 - - 7 - -  8 - 7 - - 7 - 7 8 - 7 8 - 7 - 6 ])
;;                                     |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 120)
(beats-in-bar 4)

(at-bar 1
        (rides 4)
        (hats  4)
        (sds 2) ;; 4 bar phrases, twice
        (kicks 2)
        )

;;(stop)
