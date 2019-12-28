(ns overtone-loops.dph-book.pattern-03-01
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Stop any currently playing music and clear any patterns
(set-up)

;;                                     1 & 2 & 3 & 4 & 
(defloop closed-hhs 1/2 cymbal-closed [7 7 7 7 7 7 7 7 ])
(defloop sds        1/2 snare-hard    [_ _ 8 _ _ _ 8 _ ])
(defloop kicks      1/2 bass-hard     [8 _ _ _ 8 _ _ _ ])
  
;; ---------------------------------------------

(bpm 120)
(beats-in-bar 4)

(at-bar 1
  (closed-hhs)
  (sds)
  (kicks))

;;(stop)
