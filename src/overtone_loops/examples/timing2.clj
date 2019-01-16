(ns overtone-loops.examples.timing2
  "Timing tests"
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 250547))
(def hat (freesound2 96140))

(defloop hats  3 hat  [1 0.7 0.7])
(defloop kicks 3 kick [1 0.7 0.7])

(defloop double-kicks (3 1/3) kick [1 1 0  1 1 0  1 1 0])

(bpm 90)

;; bar 1
(hats (on-next-bar 3) 9)
;; bar 2
(kicks (on-next-bar 3 2) 1)
;; bar 3
;; bar 4
(double-kicks (on-next-bar 3 4) 1)
;; bar 5
;; bar 6
(kicks (on-next-bar 3 6) 1)
;; bar 7
;; bar 8
(double-kicks (on-next-bar 3 8) 1)
;; bar 9
;; end

;;(stop)
