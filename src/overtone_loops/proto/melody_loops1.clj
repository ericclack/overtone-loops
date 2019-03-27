(ns overtone-loops.proto.melody-loops1.clj
  (:use [overtone.live]
        [overtone.inst.synth]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 56430))
(def stick (freesound2 82280))

;;                             1 e & a 2 e & a 3 e & a 4 e & a 
(defloop sticks (4 1/4) stick [8 - - - 6 - - 6 - - 6 - - 6 - - ]) 
(defloop kicks  4       kick  [8       8       8       8       ])

(defn o [anote amp]
  (overpad (note anote) :amp (/ amp 9)))

(defloop bass-line 4
  0    (o :f2 4)
  2    (o :g2 5)
  2.5  (o :b3 3)
  3.5  (o :a3 2)
  3.82 (o :g2 2)
  )

;; (emptyloop bass-line 4)

(defn k [anote amp]
  (ks1 (note anote) :amp (/ amp 9)))

(deflooplist melody1 8 k [[:g4 8] [:a4 8] [:b4 8] [:c5 8]])
;; (emptyloop melody1 8)


;;                          1 & 2 & 3 & 4 & 5 & 6  &       7       &       8      &
(defloop melody2 (8 1/2) k [- - - - - - - - - - - [:c5 8] [:a4 8] [:b4 8] [:g4 8][:f4 8]])
;; (emptyloop melody2 8)

;; ---------------------------------------------

(bpm 85)
(beats-in-bar 4)

(at-bar 1
        (sticks )
        (kicks )
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
