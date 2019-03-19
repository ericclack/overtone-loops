(ns overtone-loops.music.sticks1
  (:use [overtone.live]
        [overtone.inst.synth]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 56430))
(def stick (freesound2 82280))

;;                             1 e & a 2 e & a 3 e & a 4 e & a 
(defloop sticks (4 1/4) stick [8 - - - 6 - - 6 - - 6 - - 6 - - ]) 
(defloop kicks  4       kick  [8       8       8       8       ])


(defloop bass-line 4
  0    (overpad (note :f2) :amp 0.4)
  2    (overpad (note :g2) :amp 0.5)
  2.5  (overpad (note :b3) :amp 0.3)
  3.5  (overpad (note :a3) :amp 0.2)
  3.82 (overpad (note :g2) :amp 0.2)
  )

;; (emptyloop bass-line 4)

(defloop melody1 8
  0    (ks1 (note :g4) :amp 0.8)
  1    (ks1 (note :a4) :amp 0.8)
  2    (ks1 (note :b4) :amp 0.8)
  3    (ks1 (note :c5) :amp 0.8)
  )

;; (emptyloop melody1 8)

(defloop melody2 8
  5.5  (ks1 (note :c5) :amp 0.8)
  6    (ks1 (note :a4) :amp 0.8)
  6.5  (ks1 (note :b4) :amp 0.8)
  7    (ks1 (note :g4) :amp 0.8)   
  7.5  (ks1 (note :f4) :amp 0.8)   
  )

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
