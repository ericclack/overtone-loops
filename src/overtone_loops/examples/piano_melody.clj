(ns overtone-loops.piano-melody
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [overtone-loops.loops :refer [metro defloop defloop2]]))

;; Our loops
(defloop2 p 6
  0 (piano (note :c2))
  2 (piano (note :e3))
  3 (piano (note :g3))
  5 (piano (note :b3))
  )

(defloop2 p-high 6
  0.5 (piano (note :c5) :vel 70)
  1.5 (piano (note :b4))
  2.5 (piano (note :a4) :vel 70)
  3.5 (piano (note :c5))
  4.5 (piano (note :g5) :vel 70)
  5.5 (piano (note :b4))
  )

(defloop2 p-low 6
  0 (piano (note :g2) :vel 70)
  3 (piano (note :b2) :vel 80)
  4 (piano (note :g2) :vel 90)
)  

(comment
  (p (metro) 3)
  (p-high (metro))
  (p-low (metro) 2)
  )

;;
;;(stop)

