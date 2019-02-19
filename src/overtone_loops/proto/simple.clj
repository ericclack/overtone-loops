(ns overtone-loops.proto.simple
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))
  
;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

(defloop ticks    4  cymbal-pedal   [4   2   4   2  ])
(defloop kicks    4  bass-hard      [-   5   -   5  ])
(defloop snares   4  snare-hard     [-   -   5   -  ])
(defloop newbar   4  cowbell        [5   -   -   -  ])

;; ---------------------------------------------

(bpm 130)
(beats-in-bar 4)
  
(at-bar 1 (ticks) (kicks) (snares) (newbar))

;;(stop)
