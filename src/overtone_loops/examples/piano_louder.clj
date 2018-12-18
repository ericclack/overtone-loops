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

(defiloop piano-louder 4 piano
  0 (list :vel 50)
  1 (list :vel 70)
  2 (list :vel 80)
  3 (list :vel 100))

(piano-louder (metro))

;;
;;(stop)

