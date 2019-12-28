(ns overtone-loops.dph-book.pattern-03-10
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Quarter beats                   1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
(defloop closed-hhs 1/4 cymbal-closed
                                  [7 _ 5 _ 7 _ 4 _ 8 _ 5 _ 8 _ 6 _ ])
(defloop sds        1/4 snare     [_ _ _ _ 7 _ _ _ _ _ _ _ 7 _ _ _ ])

(defloop kicks      1/4 kick      [6 _ _ 6 _ _ _ 6 _ _ _ 7 _ _ _ _
                                   7 _ _ _ _ _ _ 6 7 _ 7 _ _ _ 6 _
                                   7 _ 6 7 _ _ _ 6 _ _ 7 _ _ 6 _ _
                                   7 _ 6 _ _ 6 _ 6 7 _ 7 8 _ 7 _ 7])
;; Quarter beats                   1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 100)
(beats-in-bar 4)

(at-bar 1
  (closed-hhs)
  (sds)
  (kicks)
  )

;;(stop)

