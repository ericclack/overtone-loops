(ns overtone-loops.piano-melody
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [overtone-loops.loops :refer [defloop defiloop metro thunk]]))

;; Our loops
;;(defiloop p 6 piano
;;  0 (note :c2)
;;  2 (note :e3)
;;  3 (note :g3)
;;  5 (note :b3)
;;  )

(defiloop p-high 6 piano
  0.5 ((note :c5) :vel 70)
  1.5 ((note :b4))
  2.5 ((note :a4) :vel 70)
  3.5 ((note :c5))
  4.5 ((note :g5) :vel 70)
  5.5 ((note :b4))
  )

;;(p (metro) 3)
(p-high (metro))

;;
;;(stop)

