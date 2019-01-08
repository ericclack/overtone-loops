(ns overtone-loops.examples.timing
  "Timing tests"
  (:use [overtone.live])
  (:require [overtone-loops.loops
             :refer [defloop bpm on-next-bar]]))

;; Define some samples from Freesound.org
(def kick (freesound 250547))
(def hat (freesound 96140))

(defloop hats 4
  0    (hat)
  1    (hat)
  2    (hat)
  3    (hat)
  )

(defloop kicks 4
  0    (kick)
  1    (kick)
  2    (kick)
  3    (kick)
  )

(defloop double-kicks 4
  0    (kick)
  0.3    (kick)
  1    (kick)
  1.3    (kick)
  2    (kick)
  2.3    (kick)
  3    (kick)
  3.3    (kick)  
  )

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