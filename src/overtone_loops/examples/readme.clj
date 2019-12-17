(ns overtone-loops.examples.readme
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up) ;; clear any previous patterns

;;                        beat   1 2 3 4 5 6 7 8
(def hats
  (loop-player 1 cymbal-closed  [_ 5 _ 5 _ 5 _ 5]))
(def kicks 
  (loop-player 1 bass-hard      [7 _ 2 _ 7 6 2 _]))
(def claps
  (loop-player 1 clap           [_ _ 4 _]))

(beats-in-bar 4)
(bpm 220)

(at-bar 1 (hats) (kicks))
(at-bar 3 (claps))

(at-bar 5
        (hats  [9 3 9 3 9 5 6 7])
        (kicks [_ _ 2 _ _ 2 _ _]))

;; return to previous patterns
(at-bar 7
        (hats :pop)
        (kicks :pop))

;; (stop)
