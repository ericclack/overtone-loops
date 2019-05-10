(ns overtone-loops.proto.alt-patterns
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))
  
;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;
(defloop countin 4       cymbal-closed  [4   4   4   4   ])
(defloop ticks   (4 1/2) cymbal-closed  [- 4 - 2 - 4 - 2 ])
(defloop kicks   (8 1/2) bass-hard      [5 - 5 - 4 - 5 - 4 2 3 4 - 7 - 4 ])
(defloop snares  (8 1/2) snare-hard     [- 1 - - - 4 - - - 1 - - - 6 - - ])

(defloop claps   (8 1/2) clap           [- - - - - - - - - - - - 7 1 8 - ])


;; ---------------------------------------------

(bpm 105)
(beats-in-bar 4)

(at-bar 1
        (play-pattern 1 bass-soft       [4   4   4   4  ])
        (play-pattern 1/2 cymbal-closed [. 4 . 2 . 4 . 2])
        (play-pattern 1/4 clap          (reverse [. . 2 . 5 4 1 2]))
        )

;;(stop)
