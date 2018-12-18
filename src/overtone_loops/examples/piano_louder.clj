(ns overtone-loops.piano-melody
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [overtone-loops.loops :refer [defloop defloop2 metro]]))

;; Our loops
(defloop2 piano-notes 6
  0 (piano (note :c3))
  2 (piano (note :e3))
  3 (piano (note :g3))
  5 (piano (note :b3))
  )

(defloop2 piano-louder 6
  0 (piano :vel 50)
  1.5 (piano :vel 70)
  3.5 (piano :vel 80)
  4 (piano :vel 100)
)

(piano-louder (metro))
(piano-notes (metro) 2)

;;
;;(stop)

