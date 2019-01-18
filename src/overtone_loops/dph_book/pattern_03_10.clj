(ns overtone-loops.dph-book.pattern-03-10
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
(defloop closed-hhs (4 1/4) closed-hh [7 - 5 - 7 - 4 - 8 - 5 - 8 - 6 - ])
(defloop sds        (4 1/4) snare     [- - - - 7 - - - - - - - 7 - - - ])

(defloop kicks      (16 1/4) kick     [6 - - 6 - - - 6 - - - 7 - - - -
                                       7 - - - - - - 6 7 - 7 - - - 6 -
                                       7 - 6 7 - - - 6 - - 7 - - 6 - -
                                       7 - 6 - - 6 - 6 7 - 7 8 - 7 - 7])
;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 100)

(do
  (closed-hhs (on-next-bar 4))
  (sds        (on-next-bar 4))
  (kicks      (on-next-bar 4))
  )

;;(stop)

