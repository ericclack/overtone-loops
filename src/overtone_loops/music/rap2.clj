(ns overtone-loops.music.rap2
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Half beats                          1   &   2   &   3   &   4   &
(defloop ticks  (4 1/2) cymbal-closed [7   5   6   5   7   5   -   3 ])
(defloop hats   (4 1/2) cymbal-pedal  [-   -   -   -   -   -   6   - ])

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a 
(defloop snares (16 1/4) snare-soft   [- - - - 7 - - - - - - - 9 - - -
                                       - - 5 - 7 - - - 7 - - - 9 - - 5
                                       - - - - 7 - - 1 - 1 - - 9 - - -
                                       - - 5 - 7 - - - 7 - - - 9 1 - 5
                                       ])

(defloop kicks  (16 1/4) bass-elec    [6 - - 6 - - - - 6 - - - - - - -
                                       6 - - 6 - - - - 6 - - - - - - -
                                       6 - - 6 - - - - 6 - 5 - 4 6 - -
                                       6 - 1 6 - 1 - 1 6 - 5 1 4 6 1 1                               
                                       ])

;; ---------------------------------------------

(bpm 105)
(beats-in-bar 4)

(at-bar 1
        (ticks )
        (hats )
        (kicks )
        (snares )
  )

;;(stop)
