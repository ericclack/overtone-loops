(ns overtone-loops.examples.piano-melody
  (:use [overtone.live]
        [overtone.inst.piano]
        [overtone-loops.loops]))

;; Our loops
(defloop p 6
  0 (piano (note :c3) :vel 70)
  2 (piano (note :e3) :vel 70)
  3 (piano (note :g3) :vel 70)
  5 (piano (note :b3) :vel 70)
  )

(defloop p-high 6
  0 (piano (note :c5))
  1.5 (piano (note :b4))
  2.5 (piano (note :a4) :vel 70)
  3.5 (piano (note :c5) :vel 70)
  4.5 (piano (note :g5) :vel 60)
  5.5 (piano (note :b4))
  )

(defloop p-low 6
  0 (piano (note :g2) :vel 60)
  3 (piano (note :b2) :vel 60)
  4 (piano (note :g2) :vel 60)
)  

(bpm 90)
(beats-in-bar 8)

(comment
  ;; Execute each of these when you like, with
  ;; Ctrl-X Ctrl-E in emacs
  (p (on-next-bar) 8)
  (p-high (on-next-bar))
  (p-low (on-next-bar) 8)
  )

;;
;;(stop)

