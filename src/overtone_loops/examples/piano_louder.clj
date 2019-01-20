(ns overtone-loops.examples.piano-louder
  "Example of piano volume variation"
  (:use [overtone.live]
        [overtone.inst.piano]
        [overtone-loops.loops]))

;; Our loops
(defloop piano-notes 6
  0 (piano (note :c3))
  2 (piano (note :e3))
  3 (piano (note :g3))
  5 (piano (note :b3))
  )

(defloop piano-louder 6
  0 (piano :vel 50)
  1.5 (piano :vel 70)
  3.5 (piano :vel 80)
  4 (piano :vel 100)
)

(bpm 90)
(beats-in-bar 8)

(piano-louder (metro) 4)
(piano-notes (on-next-bar 2) 2)

;;
;;(stop)

