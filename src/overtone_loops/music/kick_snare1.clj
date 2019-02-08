(ns overtone-loops.music.kick-snare1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.instr]))

;; Quarter beats                     1 e & a 2 e & a 3 e & a 4 e & a 
(defloop kicks  (4 1/4) kick        [6 - - - 6 - - - 6 1 - 4 6 - - - ])

(defloop hats1  (4 1/4) hatc        [- - 9 - - - 9 - - - 9 - - - 9 - ])
(defloop hats2  (4 1/4) hatp        [- - - - - 3 - - - - - - - 3 - - ])
(defloop hats3  (4 1/4) hatc2       [- - - - - - - 5 - - - - - - - 8 ])

(defloop snares (8 1/4) snare2      [- - - - - - 5 -
                                     - - - - - - 5 -
                                     - - - - - - 5 -
                                     - - - - 1 3 5 3])

(bpm 105)
(beats-in-bar 4)

(at-bar 1
        (kicks)
        (hats1)
        (hats2)
        (hats3)
        (snares)
        )

;;(stop)
