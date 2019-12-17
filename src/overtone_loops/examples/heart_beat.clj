(ns overtone-loops.examples.heart-beat
  "Simple example heartbeat pattern"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;; Our loops - both 4 beats to the bar
(def heart
  (loop-player 1 kick  [_   8   3   _  ]))

(def ticks
  (loop-player 1/2 hat [6 _ 5 _ 5 4 _ _]))

(bpm 240)
(heart (metro))
(ticks (metro))
;;

;;(stop)


