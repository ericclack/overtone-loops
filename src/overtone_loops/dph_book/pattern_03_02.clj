(ns overtone-loops.dph-book.pattern-03-01
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 270156))
(def kick (freesound2 171104))

(def crash (freesound2 439789))
(def clap (freesound2 24787))

;;                   bar1                              bar2                             bar3                        
;;                   1   &   2   &   3   &   4   &  // 1   &   2   &   3   &   4   & // 1   &   2   &   3   &   4   & // 1   &   2   &   3   &   4   & 
(defloop closed-hhs
  (4 1/2) closed-hh [0.7 0.7 0.7 0.7 0.7 0.7 0.7 0.7])
(defloop sds
  (4 1/2) snare     [0   0   0.8 0   0   0   0.8 0  ])
(defloop kicks
  (16 1/2) kick     [0.8 0   0   0   0.8 0   0   0     0.8 0   0   0   0.8 0.8 0   0    0.8 0.8 0   0   0   0.8 0   0    0.8 0.8 0 0.8 0 0.8 0 0.8])
  
;; ---------------------------------------------

(bpm 120)
  
(do
  (closed-hhs (on-next-bar 4))
  (sds        (on-next-bar 4))
  (kicks      (on-next-bar 4))
  )

;;(stop)
