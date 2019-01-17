(ns overtone-loops.dph-book.pattern-03-01
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 270156))
(def kick (freesound2 171104))

(def crash (freesound2 439789))
(def clap (freesound2 24787))

;;                   BAR1               BAR2               BAR3               BAR4                        
;;                   1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop closed-hhs
  (4 1/2) closed-hh [7 7 7 7 7 7 7 7 ])
(defloop sds
  (4 1/2) snare     [- - 8 - - - 8 - ])
(defloop kicks
  (16 1/2) kick     [8 - - - 8 - - -    8 - - - 8 8 - -    8 8 - - - 8 - -    8 8 - 8 - 8 - 8])
  
;; ---------------------------------------------

(bpm 120)
  
(do
  (closed-hhs (on-next-bar 4))
  (sds        (on-next-bar 4))
  (kicks      (on-next-bar 4))
  )

;;(stop)
