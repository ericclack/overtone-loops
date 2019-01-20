(ns overtone-loops.dph-book.pattern-03-12
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def open-hh (freesound2 404893))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
(defloop closed-hhs (4 1/4) closed-hh [7 - - - 7 - - - 7 - - 1 7 - - - ])
(defloop open-hhs   (4 1/4) open-hh   [7 - - - 7 - - - 7 - - 1 7 - - - ])

(defloop sds        (16 1/4) snare    [- - - - 7 - - - - 5 - - 7 - - -  - - - - 7 - - - - - - - 7 - - 5  - 5 - - 7 - 6 - - - - - 7 - - -  - - - - 7 - - - - 5 - - 7 - - - ])
(defloop kicks      (16 1/4) kick     [6 - - 6 - - - 6 - - 7 - - - - -  6 - - - - - - 5 6 - 7 - - - 7 -  7 - 6 7 - - - 7 - - 7 - - 7 - -  8 - 7 - - 7 - 7 8 - 7 8 - 7 - 6 ])
;;                                     |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 120)
(beats-in-bar 4)

(at-bar 1
        (closed-hhs 4)
        (sds 2) ;; 4 bar phrases, twice
        (kicks 2)
        )

(at-bar 5
        (open-hhs 4))

;;(stop)
