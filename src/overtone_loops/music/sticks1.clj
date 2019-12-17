(ns overtone-loops.music.sticks1
  (:use [overtone.live]
        [overtone.inst.synth]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;;                          1 e & a 2 e & a 3 e & a 4 e & a 
(defloop sticks 1/4 stick  [8 _ _ _ 6 _ _ 6 _ _ 6 _ _ 6 _ _ ]) 
(defloop kicks  1   kick   [8       8       8       8       ])
(defloop clicks 1/4 finger [_ _ _ 3 _ _ 4 _ _ 3 _ _ _ _ 5 _ ])

(defn o [[n a]]
  (overpad (note n) :amp (/ a 9)))

;;                      
(defloop bass-line 1/4 o [[:f2 4] _ _ _  _ _ _ _  [:g2 5] _ [:b3 3] _  _ _ [:a3 2] [:g2 2]])

(defn k [[n a]]
  (ks1 (note n) :amp (/ a 9)))

(defloop melody1 1 k   [[:g4 8] [:a4 8] [:b4 8] [:c5 8] _ _ _ _])

;;                      1   2   3   4    5   6         7               8 
(defloop melody2 1/2 k [_ _ _ _ _ _ _ _  _ _ _ [:c5 8] [:a4 8] [:b4 8] [:g4 8] [:f4 8]])

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
  (melody1 (metro))
  )

;;(stop)
