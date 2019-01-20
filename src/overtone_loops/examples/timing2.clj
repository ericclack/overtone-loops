(ns overtone-loops.examples.timing2
  "Timing tests"
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 250547))
(def hat (freesound2 96140))

;; We want to use amps between 0 and 1 in our lists
(amp-scale 1)

(defloop hats  3 hat  [1 0.7 0.7])
(defloop kicks 3 kick [1 0.7 0.7])

(defloop double-kicks (3 1/3) kick [1 1 0  1 1 0  1 1 0])

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
