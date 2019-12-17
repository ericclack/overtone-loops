(ns overtone-loops.examples.heart-beat2
  "Heart beat pattern"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))


(set-up)

(def heart          ;;   1       2       3       4
  (loop-player 1/4 kick [8 _ _ _ 8 _ _ _ _ _ 3 5 6 _ _ _]))

(def ticks          ;;   1                  2                  3                  4
  (loop-player 1/9 hat  [8 _ _ _ _ _ _ _ _  8 _ _ _ 4 _ _ 3 _  8 _ _ _ _ _ _ _ _  8 _ _ _ _ 5 _ _ _ ]))

(bpm 200)
(heart (metro))
(ticks (metro))

;;(stop)
