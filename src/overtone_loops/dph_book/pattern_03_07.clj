(ns overtone-loops.dph-book.pattern-03-07
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

;;                   BAR1               BAR2               BAR3               BAR4                        

;;                                     1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop closed-hhs (4 1/2) closed-hh [7 3 7 3 7 3 7 6 ])
(defloop sds        (4 1/2) snare     [- - 7 - - - 7 - ])
(defloop kicks      (4 1/2) kick      [7 7 - - - 7 - - ])

(bpm 110)
(beats-in-bar 4)

(at-bar 1
  (closed-hhs )
  (sds        )
  (kicks      )
  )

;;(stop)
