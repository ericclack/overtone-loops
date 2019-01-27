(ns overtone-loops.dph-book.pattern-04-01
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
;;                                     |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
(defloop closed-hhs (8 1/4) closed-hh [5 3 7 5 5 4 8 4 5 4 7 6 4 4 8 4  4 3 8 5 5 6 7 6 5 4 7 6 5 4 8 7 ])

(defloop sds        (8 1/4) snare     [- - - - 7 - - - - 5 - - 7 - - -  - - - - 7 - - - - - - - 7 - - 5 ])
(defloop kicks      (8 1/4) kick      [6 - - 6 - - - 6 - - 7 - - - - -  6 - - - - - - 5 6 - 7 - - - 7 - ])
;;                                     |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 86)
(beats-in-bar 4)

(at-bar 1
  (closed-hhs)
  (sds)
  (kicks)
  )

;;(stop)
