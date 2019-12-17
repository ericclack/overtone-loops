(ns overtone-loops.examples.timing
  "Timing tests"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

(defloop hats  1 cymbal-pedal  [6 6 6 6])
(defloop kicks 1 bass-hard     [9 9 9 9])

(defloop double-kicks 1/3 bass-soft [9 9 _
                                     9 9 _
                                     9 9 _
                                     9 9 _])
(bpm 90)
(beats-in-bar 4)

(at-bar 1
        (hats))

(at-bar 2
        (kicks))

(at-bar 4
        (kicks [])
        (double-kicks))

(at-bar 6
        (double-kicks [])
        (kicks :first))

(at-bar 8
        (double-kicks []))

;; bar 9
;; end

;;(stop)
