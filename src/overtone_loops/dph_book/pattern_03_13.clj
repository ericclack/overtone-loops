(ns overtone-loops.dph-book.pattern-03-13
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
(defloop closed-hhs 1/4 cymbal-closed [_ _ 7 _ _ _ 7 _ _ _ 7 _ _ 1 7 _ ])
(defloop open-hhs   1/4 cymbal-open   [_ _ 7 _ _ _ 7 _ _ _ 7 _ _ 1 7 _ ])

(defloop sds        1/4 snare         [_ _ _ _ 7 _ _ _ _ 5 _ _ 7 _ _ _  _ _ _ _ 7 _ _ _ _ _ _ _ 7 _ _ 5  _ 5 _ _ 7 _ 6 _ _ _ _ _ 7 _ _ _  _ _ _ _ 7 _ _ _ _ 5 _ _ 7 _ _ _ ])
(defloop kicks      1/4 kick          [6 _ _ 6 _ _ _ 6 _ _ 7 _ _ _ _ _  6 _ _ _ _ _ _ 5 6 _ 7 _ _ _ 7 _  7 _ 6 7 _ _ _ 7 _ _ 7 _ _ 7 _ _  8 _ 7 _ _ 7 _ 7 8 _ 7 8 _ 7 _ 6 ])
;;                                     |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 120)
(beats-in-bar 4)

(at-bar 1
        (closed-hhs)
        (sds)
        (kicks)
        )

(at-bar 5
        (open-hhs))

;;(stop)
