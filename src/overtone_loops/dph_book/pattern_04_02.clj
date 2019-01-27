(ns overtone-loops.dph-book.pattern-04-02
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
(defloop closed-hhs (8 1/4) closed-hh [8 2 4 7 - 2 4 5 8 - 7 3 - 6 3 8  9 2 6 4 - 8 4 8 9 3 5 7 - 4 8 - ])

(defloop sds        (8 1/4) snare     [- - - - 7 - - - - 5 - - 7 - - -  - - - - 7 - - - - - - - 7 - - 5 ])
(defloop kicks      (8 1/4) kick      [6 - - 6 - - - 6 - - 7 - - - - -  6 - - - - - - 5 6 - 7 - - - 7 - ])
;;                                     |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 116)
(beats-in-bar 4)

(at-bar 1
  (closed-hhs)
  (sds)
  (kicks)
  )

;;(stop)
