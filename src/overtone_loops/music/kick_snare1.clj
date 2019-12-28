(ns overtone-loops.music.kick-snare1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a 
(defloop kicks  1/4 bass-hard     [6 _ _ _ 6 _ _ _ 6 1 _ 4 6 _ _ _ ])

(defloop hats1  1/4 cymbal-closed [_ _ 9 _ _ _ 9 _ _ _ 9 _ _ _ 9 _ ])
(defloop hats2  1/4 cymbal-pedal  [_ _ _ _ _ 3 _ _ _ _ _ _ _ 3 _ _ ])
(defloop hats3  1/4 ride-bell     [_ _ _ _ _ _ _ 2 _ _ _ _ _ _ _ 3
                                   _ _ _ _ _ _ _ _ 3 _ 5 _ 3 _ 5 2 ])

(defloop snares 1/4 snare-hard    [_ _ _ _ _ _ 7 _
                                   _ _ _ _ _ _ 7 _
                                   _ _ _ _ _ _ 7 _
                                   _ _ _ _ 1 3 7 3])

(bpm 105)
(beats-in-bar 4)

(at-bar 1
        (hats1))

(at-bar 2
        (kicks)
        (hats2)
        (hats3))

(at-bar 4
        (snares))

;;(stop)
