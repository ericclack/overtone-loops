(ns overtone-loops.proto.simple
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))


(set-up)

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

(defloop ticks    1  cymbal-pedal   [4   2   4   2  ])
(defloop kicks    1  bass-hard      [_   5   _   5  ])
(defloop snares   1  snare-hard     [_   _   5   _  ])
(defloop newbar   1  cowbell        [5   _   _   _  ])

;; ---------------------------------------------

(bpm 130)
(beats-in-bar 4)
  
(at-bar 1
        (ticks)
        (kicks)
        (snares)
        (newbar))

;;(stop)
