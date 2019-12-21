(ns overtone-loops.dph-book.pattern-03-02
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                   BAR1               BAR2               BAR3               BAR4                        
;;                   1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop closed-hhs
  1/2 cymbal-closed [7 7 7 7 7 7 7 7 ])
(defloop sds
  1/2 snare-hard    [_ _ 8 _ _ _ 8 _ ])
(defloop kicks
  1/2 bass-hard     [8 _ _ _ 8 _ _ _    8 _ _ _ 8 8 _ _    8 8 _ _ _ 8 _ _    8 8 _ 8 _ 8 _ 8])
  
;; ---------------------------------------------

(bpm 120)
(beats-in-bar 4)
  
(at-bar 1
  (closed-hhs )
  (sds        )
  (kicks      )
  )

;;(stop)
