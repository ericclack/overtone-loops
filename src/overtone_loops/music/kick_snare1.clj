(ns overtone-loops.music.kick-snare1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a 
(defloop kicks  (4 1/4) bass-hard     [6 - - - 6 - - - 6 1 - 4 6 - - - ])

(defloop hats1  (4 1/4) cymbal-closed [- - 9 - - - 9 - - - 9 - - - 9 - ])
(defloop hats2  (4 1/4) cymbal-pedal  [- - - - - 3 - - - - - - - 3 - - ])
(defloop hats3  (8 1/4) cymbal-open   [- - - - - - - 2 - - - - - - - 3
                                       - - - - - - - - 3 - 5 - 3 - 5 2 ])

(defloop snares (8 1/4) snare-hard    [- - - - - - 7 -
                                       - - - - - - 7 -
                                       - - - - - - 7 -
                                       - - - - 1 3 7 3])

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
