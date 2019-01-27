(ns overtone-loops.dph-book.pattern-04-13
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def ride-bell (freesound2 171482))
(def ride (freesound2 162311))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                   BAR1               BAR2               BAR3               BAR4                        
;;                   1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop sds
  (4 1/2) snare     [- - 8 - - - 8 - ])
(defloop kicks
  (16 1/2) kick     [8 - - 8 - - - -    - 8 - 8 - - - -    8 - - 8 8 - - 8    8 8 - 8 - - - 8  ])

;;                   1 e & a 2 e & a 3 e & a 4 e & a  
(defloop ride-bells
  (4 1/4) ride-bell [- - 5 - - - 5 - - - 5 - - - 5 - ])

(defloop rides
  (4 1/4) ride      [4 5 - - 4 5 - - 5 4 - - 4 3 - - ])
  
;; ---------------------------------------------

(bpm 100)
(beats-in-bar 4)
  
(at-bar 1
        (ride-bells )
        (rides)
        (sds        )
        (kicks      )
  )

;;(stop)
