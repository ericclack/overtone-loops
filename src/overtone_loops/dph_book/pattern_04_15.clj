(ns overtone-loops.dph-book.pattern-04-15
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
  (16 1/2) closed-hh [7 7 7 7 7 - 7 7    7 7 7 7 - - - 7    - - - 7 7 - 7 7    7 - - 7 - 7 - 7  ])

(defloop sds
  (16 1/2) snare     [- - 8 - - - 8 -    - - 8 - - - 8 -    - - 8 - - - 8 3    - - 8 - 6 - 8 -  ])
(defloop kicks
  (16 1/2) kick      [8 - - - 8 - - -    8 2 - - 8 - - -    8 - - - 8 2 - -    8 - - - - 4 - 4  ])

;; ---------------------------------------------

(bpm 130)
(beats-in-bar 4)
  
(at-bar 1
        (sds)
        (kicks)
        (closed-hhs)
        (open-hhs (metro))
        )

;;(stop)
