(ns overtone-loops.dph-book.pattern-03-03
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                        BAR1               BAR2               BAR3               BAR4                        
;;                        1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop closed-hhs
  (4 1/2) cymbal-closed  [7 7 7 7 7 7 7 7 ])
(defloop sds
  (4 1/2) snare-hard     [- - 8 - - - 8 - ])

(defloop kicks
  (32 1/2) bass-hard     [8 - - - 8 - - -    8 - - - 8 8 - -    8 8 - - - 8 - -    8 8 - 8 - 8 - 8
                          - - 8 - - 4 8 -    8 8 8 - - 8 - -    8 - - - 8 8 - -    8 4 8 4 8 4 8 4])
  
;; ---------------------------------------------

(bpm 120)
(beats-in-bar 4)
  
(at-bar 1
  (closed-hhs )
  (sds        )
  (kicks      )
  )

;;(stop)
