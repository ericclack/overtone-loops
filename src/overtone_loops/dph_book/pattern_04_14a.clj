(ns overtone-loops.dph-book.pattern-04-14a
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def open-hh (freesound2 404893))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                    BAR1               BAR2               BAR3               BAR4                        
;;                    1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop open-hhs
  (16 1/2) open-hh   [- - - - - 7 - -    - - - - - 7 - -    - 7 - - - 7 - -    - 7 - - 7 - 7 -  ])
(defloop closed-hhs
  (16 1/2) closed-hh [7 7 - 7 7 - - 7    7 7 - 7 7 - 7 7    7 - - 7 - - 7 7    7 - 7 7 - 7 - 7  ])

(defloop sds
  (4 1/2) snare      [- - 8 - - - 8 -  ])
(defloop kicks
  (4 1/2) kick       [8 - - - 8 - - -  ])

;; ---------------------------------------------

(bpm 112)
(beats-in-bar 4)
  
(at-bar 1
        (sds)
        (kicks)
        (closed-hhs)
        (open-hhs (metro))
        )

;;(stop)
