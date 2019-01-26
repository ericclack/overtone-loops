(ns overtone-loops.dph-book.pattern-04-03
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 270156))
(def kick (freesound2 171104))

(def crash (freesound2 439789))
(def clap (freesound2 24787))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                    BAR1              
;;                    1 e & a 2 e & a 3 e & a 4 e & a 
(defloop closed-hhs
  (12 1/4) closed-hh [8 3 4 6 7 2 6 7 8 1 2 3 4 8 2 1
                      2 4 8 3 2 3 2 3 8 2 8 5 3 4 8 8
                      2 - 7 - 3 - 7 - - 2 - 7 - 2 - 7])

;;                   BAR1               BAR2               BAR3               BAR4                        
;;                   1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop sds
  (4 1/2) snare     [- - 6 - - - 6 - ])
(defloop kicks
  (4 1/2) kick      [7 - - - 7 6 - 1 ])
  
;; ---------------------------------------------

(bpm 120)
(beats-in-bar 4)
  
(at-bar 1
  (closed-hhs )
  (sds        )
  (kicks      )
  )

;;(stop)
