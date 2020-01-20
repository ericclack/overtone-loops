(ns overtone-loops.examples.kick-kick-snare
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;;                           1 & 2 & 3 & 4 &
(defloop kicks  1/2 kick    [8 _ 7 _ _ _ _ _])
(defloop snares 1/2 snare   [_ _ _ _ 8 _ _ _])
(defloop hats   1/2 hat     [_ 5 _ 5 _ 5 _ 5])

(bpm 140)
(beats-in-bar 4)
(at-bar 1
  (kicks)
  (snares)
  (hats)
  )

;;(stop)
