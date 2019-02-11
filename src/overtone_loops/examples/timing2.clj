(ns overtone-loops.examples.timing2
  "Timing tests"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(defloop hats  3 cymbal-closed          [9 7 7])
(defloop kicks 3 bass-soft              [9 7 7])

(defloop double-kicks (3 1/3) bass-soft [9 9 -
                                         9 9 -
                                         9 9 -])

(bpm 90)
(beats-in-bar 3)

(at-bar 1
        (hats 9))

(at-bar 2
        (kicks 1))

(at-bar 4
        (double-kicks 1))

(at-bar 6
        (kicks 1))

(at-bar 8
        (double-kicks 1))

;; bar 9
;; end

;;(stop)
