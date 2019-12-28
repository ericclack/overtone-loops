(ns overtone-loops.examples.heart-beat
  "Simple example heartbeat pattern"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)
(bpm 240)
(beats-in-bar 4)

;; Our loops - both 4 beats to the bar
(def heart
  (loop-player 1 kick  [ _   8   6   _   ]))

(def ticks
  (loop-player 1/2 hat [ 4 _ 3 _ 4 _ 4 _ ]))

;; Schedule
(at-bar 1
        (heart)
        (ticks))
                      
;;

;;(stop)


