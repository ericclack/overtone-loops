(ns overtone-loops.examples.closer2
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def hat (freesound2 404890))
(def ride-bell (freesound2 171482))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

(def bell (freesound2 382806))

;;                                 1 & 2 & 3 & 4 & 
(defloop hats   (4 1/2) hat       [- 5 - 5 - 5 - 5 ])
(defloop rides  (4 1/2) ride-bell [5 - 6 - 7 - 5 - ])

(defloop snares (16 1/2) snare    [- - 7 - - - 7 -  - - 7 - - - 7 -  - - 7 2 - - 7 3  - 3 7 - - 6 7 5 ])

(defloop kicks  (4 1/2) kick      [7 - - 7 - - - 3 ])
(defloop kicks2 (4 1/2) kick      [- - 5 - - 8 - 3 ])
  
;; ---------------------------------------------

(bpm 110)

(defn half-beat? [b]
  (and (ratio? b)
       (= (denominator b) 2)))

(defn bit-later [b]
  (+ b 1/7))

(at-bar 1
        (hats)
        (kicks)
        )

(at-bar 3
        (snares 8)
        )

(at-bar 7
        (rides 2)
        )

(at-bar 9
        (kicks2 2 bit-later)
        )

;;(stop)
