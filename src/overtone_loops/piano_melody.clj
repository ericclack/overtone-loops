(ns overtone-loops.piano-melody
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [overtone-loops.loops :refer [defloop metro thunk]]))

;; Our loops
(defloop p 6
  0 (thunk (piano (note :c2)))
  2 (thunk (piano (note :e3)))
  3 (thunk (piano (note :g3)))
  5 (thunk (piano (note :b3)))
  )

(defloop p-high 6
  0.5 (thunk (piano (note :c5) :vel 70))
  1.5 (thunk (piano (note :b4)))
  2.5 (thunk (piano (note :a4) :vel 70))
  3.5 (thunk (piano (note :c5)))
  4.5 (thunk (piano (note :g5) :vel 70))
  5.5 (thunk (piano (note :b4)))
  )

(defloop p-low 6
  0 (thunk (piano (note :g2) :vel 70))
  3 (thunk (piano (note :b2) :vel 80))
  4 (thunk (piano (note :g2) :vel 90))
)  

(p (metro) 3)
(p-high (metro))
(p-low (metro) 2)

;;
;;(stop)

(piano (note :c2))
(name :a2)

(note-info "a2")
(note-info "b2")
(note-info "c3")

