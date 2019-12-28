(ns overtone-loops.dph-book.pattern-03-07
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Stop any currently playing music and clear any patterns
(set-up)

;;                   BAR1               BAR2               BAR3               BAR4                        

;;                                 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop closed-hhs 1/2 cymbal-closed [7 3 7 3 7 3 7 6 ])
(defloop sds        1/2 snare     [_ _ 7 _ _ _ 7 _ ])
(defloop kicks      1/2 kick      [7 7 _ _ _ 7 _ _ ])

(bpm 110)
(beats-in-bar 4)

(at-bar 1
  (closed-hhs )
  (sds        )
  (kicks      )
  )

;;(stop)
