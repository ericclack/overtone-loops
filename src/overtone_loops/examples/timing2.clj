(ns overtone-loops.examples.timing2
  "Timing tests"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

(defloop hats  1 cymbal-closed          [7 5 5])
(defloop kicks 1 bass-soft              [7 5 5])

(defloop double-kicks 1/3 bass-soft [7 7 _
                                     7 7 _
                                     7 7 _])

(bpm 90)
(beats-in-bar 3)

(at-bar 1
        (hats))

(at-bar 2
        (kicks))

(at-bar 4
        (silence kicks)
        (double-kicks))

(at-bar 6
        (kicks :first)
        (silence double-kicks))

(at-bar 9
        (silence kicks hats))

;;(stop)
