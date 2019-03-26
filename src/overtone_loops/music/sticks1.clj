(ns overtone-loops.music.sticks1
  (:use [overtone.live]
        [overtone.inst.synth]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;;                              1 e & a 2 e & a 3 e & a 4 e & a 
(defloop sticks (4 1/4) stick  [8 - - - 6 - - 6 - - 6 - - 6 - - ]) 
(defloop kicks  4       kick   [8       8       8       8       ])
(defloop clicks (4 1/4) finger [- - - 1 - - 2 - - 1 - - - - 3 - ])

(defn o [n a]
  (overpad (note n) :amp a))

(defloop bass-line 4
  0    (o :f2 0.4)
  2    (o :g2 0.5)
  2.5  (o :b3 0.3)
  3.5  (o :a3 0.2)
  3.82 (o :g2 0.2)
  )

;; (emptyloop bass-line 4)

(defn k [n a]
  (ks1 (note n) :amp a))

(defloop melody1 8
  0    (k :g4 0.8)
  1    (k :a4 0.8)
  2    (k :b4 0.8)
  3    (k :c5 0.8)
  )

;; (emptyloop melody1 8)

(defloop melody2 8
  5.5  (k :c5 0.8)
  6    (k :a4 0.8)
  6.5  (k :b4 0.8)
  7    (k :g4 0.8)   
  7.5  (k :f4 0.8)   
  )

;; (emptyloop melody2 8)

;; ---------------------------------------------

(bpm 85)
(beats-in-bar 4)

(at-bar 1
        (sticks )
        (kicks )
        )

(at-bar 3
        (clicks)
        )

(at-bar 5
        (bass-line )
        )

(at-bar 13
        (melody1)
        )

(at-bar 17
        (melody2)
        )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  )

;;(stop)
