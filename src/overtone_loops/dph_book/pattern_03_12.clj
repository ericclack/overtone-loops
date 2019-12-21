(ns overtone-loops.dph-book.pattern-03-12
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def open-hh (freesound2 404893))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Quarter beats
;; 1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
(defloop closed-hhs 1/4 closed-hh
  [7 _ _ _ 7 _ _ _ 7 _ _ 1 7 _ _ _ ])
(defloop open-hhs   1/4 open-hh
  [7 _ _ _ 7 _ _ _ 7 _ _ 1 7 _ _ _ ])

(defloop sds        1/4 snare
  [_ _ _ _ 7 _ _ _ _ 5 _ _ 7 _ _ _  _ _ _ _ 7 _ _ _ _ _ _ _ 7 _ _ 5  _ 5 _ _ 7 _ 6 _ _ _ _ _ 7 _ _ _  _ _ _ _ 7 _ _ _ _ 5 _ _ 7 _ _ _ ])
(defloop kicks      1/4 kick
  [6 _ _ 6 _ _ _ 6 _ _ 7 _ _ _ _ _  6 _ _ _ _ _ _ 5 6 _ 7 _ _ _ 7 _  7 _ 6 7 _ _ _ 7 _ _ 7 _ _ 7 _ _  8 _ 7 _ _ 7 _ 7 8 _ 7 8 _ 7 _ 6 ])
;; |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
;; 1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 120)
(beats-in-bar 4)

(at-bar 1
        (closed-hhs)
        (sds) ;; 4 bar phrases, twice
        (kicks)
        )

(at-bar 5
        (closed-hhs [])
        (open-hhs))

;;(stop)
