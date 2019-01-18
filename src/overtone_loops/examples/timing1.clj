(ns overtone-loops.examples.timing
  "Timing tests"
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 250547))
(def hat (freesound2 96140))

;; We want to use amps between 0 and 1 in our lists
(amp-scale 1)

(defloop hats  4 hat  [1 1 1 1])
(defloop kicks 4 kick [1 1 1 1])

(defloop double-kicks (4 1/3) kick [1 1 0  1 1 0  1 1 0  1 1 0])
(bpm 90)

;; bar 1
(hats (on-next-bar 4) 9)
;; bar 2
(kicks (on-next-bar 4 2) 1)
;; bar 3
;; bar 4
(double-kicks (on-next-bar 4 4) 1)
;; bar 5
;; bar 6
(kicks (on-next-bar 4 6) 1)
;; bar 7
;; bar 8
(double-kicks (on-next-bar 4 8) 1)
;; bar 9
;; end

;;(stop)
