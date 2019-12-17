(ns overtone-loops.music.walk1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;; Quarter beats                   1 e & a 2 e & a 3 e & a 4 e & a 
(defloop kicks  1/4 bass-hard     [6 _ _ _ 6 _ _ _ 6 _ _ _ 6 _ _ _
                                   4 _ 6 _ 4 _ 6 _ 4 _ 6 _ 4 _ _ _
                                   6 _ _ _ 6 _ _ _ _ _ 6 _ 6 _ _ _
                                   6 _ 1 1 6 _ 1 _ 6 _ 1 _ 6 _ 1 _])
(defloop hats   1/4 cymbal-closed [_ 4 6 _ _ 1 6 _ _ 4 6 _ _ 2 2 2])
(defloop rides  1/4 ride-bell     [_ _ 4 _ _ _ 3 _ _ _ 3 _ 4 _ 3 _
                                   _ _ 2 _ _ _ 2 _ _ _ 3 1 _ _ 3 4
                                   ])

(bpm 110)
(beats-in-bar 4)
(at-bar 1
        (kicks)
        (hats)
        )

(at-bar 5 
        (rides)
        )

(at-bar 9
        (rides [])
        )

;;(stop)
