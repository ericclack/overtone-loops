(ns overtone-loops.examples.timing
  "Timing tests"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)
(bpm 90)
(beats-in-bar 4)

(defloop hats  1 cymbal-pedal  [6 6 6 6])
(defloop kicks 1 bass-hard     [7 7 7 7])

(defloop double-kicks 1/3 bass-soft [7 7 _
                                     7 7 _
                                     7 7 _
                                     7 7 _])
(at-bar 1
        (hats))

(at-bar 2
        (kicks))

(at-bar 4
        (silence kicks)
        (double-kicks))

(at-bar 6
        (silence double-kicks)
        (kicks :first))

(at-bar 8
        (silence kicks hats))

;; bar 9
;; end

;;(stop)
