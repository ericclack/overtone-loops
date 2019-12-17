(ns overtone-loops.proto.beats
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))
  
;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;
(defloop countin 1   cymbal-closed  [4   4   4   4   ])
(defloop ticks   1/2 cymbal-closed  [_ 4 _ 2 _ 4 _ 2 ])
(defloop kicks   1/2 bass-hard      [5 _ 5 _ 4 _ 5 _ 4 2 3 4 _ 7 _ 4 ])
(defloop snares  1/2 snare-hard     [_ 1 _ _ _ 4 _ _ _ 1 _ _ _ 6 _ _ ])

(defloop claps   1/2 clap           [_ _ _ _ _ _ _ _ _ _ _ _ 7 1 8 _ ])


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
        (kicks)
        (snares)
        (claps)
        )

;;(stop)
