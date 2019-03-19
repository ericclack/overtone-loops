(ns overtone-loops.proto.beats
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

(defn late [b]
  (+ b (* (rand) 0.05)))

(defn early [b]
  (- b (* (rand) 0.05)))


(at-bar 1
        (countin))

(at-bar 2
        (ticks)
        (kicks early)
        (snares)
        (claps early)
        )

;;(stop)
