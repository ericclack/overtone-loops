(ns overtone-loops.examples.timing2
  "Timing tests"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(defloop hats  1 cymbal-closed          [9 7 7])
(defloop kicks 1 bass-soft              [9 7 7])

(defloop double-kicks 1/3 bass-soft [9 9 _
                                     9 9 _
                                     9 9 _])

(bpm 90)
(beats-in-bar 3)

(at-bar 1
        (hats))

(at-bar 2
        (kicks))

(at-bar 4
        (kicks [])
        (double-kicks))

(at-bar 6
        (kicks :first)
        (double-kicks []))

;; bar 9
;; end

;;(stop)
