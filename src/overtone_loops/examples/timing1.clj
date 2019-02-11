(ns overtone-loops.examples.timing
  "Timing tests"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(defloop hats  4 cymbal-pedal  [6 6 6 6])
(defloop kicks 4 bass-hard     [9 9 9 9])

(defloop double-kicks (4 1/3) bass-soft [9 9 -
                                         9 9 -
                                         9 9 -
                                         9 9 -])
(bpm 90)
(beats-in-bar 4)

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
