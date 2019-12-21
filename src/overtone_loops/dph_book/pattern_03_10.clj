(ns overtone-loops.dph-book.pattern-03-10
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Quarter beats                   1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
(defloop closed-hhs 1/4 closed-hh [7 _ 5 _ 7 _ 4 _ 8 _ 5 _ 8 _ 6 _ ])
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

