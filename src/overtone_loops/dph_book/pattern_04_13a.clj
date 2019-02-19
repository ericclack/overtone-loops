(ns overtone-loops.dph-book.pattern-04-13a
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                     BAR1               BAR2               BAR3               BAR4                        
;;                     1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop sds
  (16 1/2) snare-hard [- - 5 - - - 5 -    - - 5 - 2 4 - 6    - - 5 - - - 5 -    - - 5 - - - 5 -  ])
(defloop kicks
  (16 1/2) bass-hard  [8 - - 8 - - - 5    - 8 - 8 - - - -    8 - - 8 8 - - 8    8 3 - 8 - - - 8  ])

;;                     1 e & a 2 e & a 3 e & a 4 e & a  
(defloop ride-bells
  (4 1/4) ride-bell   [- - 5 - - - 5 - - - 5 - - - 5 - ])

(defloop rides
  (4 1/4) ride        [4 5 - - 4 5 - - 5 4 - - 4 3 - - ])
  
;; ---------------------------------------------

(bpm 100)
(beats-in-bar 4)
  
(at-bar 1
        (ride-bells)
        (rides)
        (sds)
        (kicks)
  )

;;(stop)
