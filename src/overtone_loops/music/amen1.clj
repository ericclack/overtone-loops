(ns overtone-loops.music.amen1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

(def hats1
  (loop-player 1 cymbal-closed [2   2   2   2]))

(def hats2
  (loop-player 1 cymbal-open   [3   3   3   3]))

(def kicks1
  (loop-player 1/2 bass-soft   [7 _ 7 _ _ _ _ _ _ _ 3 4 _ _ _ _]))

(def snares1
  (loop-player 1/2 snare       [_ _ _ _ 7 _ _ 3 _ 3 _ _ 3 _ _ 7]))

;; ---------------------------------------------

(bpm 220)
(beats-in-bar 8)

(at-bar 1
  (hats1 )
  (kicks1 )
  (snares1 )
  )

;;(stop)
