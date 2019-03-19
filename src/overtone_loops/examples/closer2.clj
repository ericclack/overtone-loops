(ns overtone-loops.examples.closer2
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;;                                 1 & 2 & 3 & 4 & 
(defloop hats   (4 1/2) hat       [- 5 - 5 - 5 - 5 ])
(defloop rides  (4 1/2) ride-bell [5 - 6 - 7 - 5 - ])

(defloop snares (16 1/2) snare    [- - 7 - - - 7 -  - - 7 - - - 7 -  - - 7 2 - - 7 3  - 3 7 - - 6 7 5 ])

(defloop kicks  (4 1/2) kick      [7 - - 7 - - - 3 ])
(defloop kicks2 (4 1/2) kick      [- - - 5 - - - 2 ])
  
;; ---------------------------------------------

(bpm 110)

(defn bit-later [b]
  (+ b 1/7))

(at-bar 1
        (hats)
        (kicks)
        )

(at-bar 3
        (snares 8)
        )

(at-bar 5
        (kicks2 2 bit-later)
        )

(at-bar 7
        (rides 2)
        )

;;(stop)
