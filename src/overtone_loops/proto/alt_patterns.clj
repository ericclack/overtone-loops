(ns overtone-loops.proto.alt-patterns
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))
  
(bpm 105)
(beats-in-bar 4)

(bars-repeat 4
  (play-pattern 1 bass-soft       [4   4   4   4  ])
  (play-pattern 1/2 cymbal-closed [. 4 . 2 . 4 . 2])
  (play-pattern 1/4 clap          [. . 2 . . 5 1 2])
  )


;;(stop)
