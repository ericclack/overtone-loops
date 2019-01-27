(ns overtone-loops.dph-book.pattern-04-12a
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

(def crash (freesound2 439789))
(def clap (freesound2 24787))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                    BAR1               BAR2               BAR3               BAR4                        
;;                    1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop sds
  (16 1/2) snare     [- - 8 - - - 8 -    - - 8 - - - 8 -    - 3 8 - - - 8 -    - - 8 - - 3 8 4 ])
(defloop kicks
  (16 1/2) kick      [8 - - 8 - - - -    - 8 - 8 - - - -    8 - - 8 5 - - 8    5 8 - 8 - - - 8 ])

;;                    1 e & a 2 e & a 3 e & a 4 e & a  
(defloop closed-hhs
  (16 1/4) closed-hh [8 - 3 4 8 - 1 4 8 1 - 8 - 3 4 8
                      - 1 4 8 1 - 8 - 3 4 8 - 1 4 8 1
                      - 8 - 3 4 8 - 1 4 8 1 - 8 - 3 4
                      8 - 1 4 8 1 - 8 - 3 4 8 - 1 4 8 ])
  
;; ---------------------------------------------

(bpm 120)
(beats-in-bar 4)
  
(at-bar 1
  (closed-hhs )
  (sds        )
  (kicks      )
  )

;;(stop)
