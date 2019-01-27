(ns overtone-loops.dph-book.pattern-04-05
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
;;                    1 t t 2 t t 3 t t 4 t t   1 t t 2 t t 3 t t 4 t t
(defloop closed-hhs
  (4 1/3) closed-hh  [8 3 5 8 3 5 8 3 5 8 3 5   8 3 5 8 3 5 8 3 5 8 3 5 ])
(defloop sds
  (8 1/3) snare      [- - - 6 - - - - - 6 - -   - - 6 - - - - - - 6 - - ])
(defloop kicks
  (8 1/3) kick       [7 - 6 - 7 - 7 - - - - 7   8 7 - - 5 6 - 7 8 - - - ])
  
;; ---------------------------------------------

(bpm 90)
(beats-in-bar 4)
  
(at-bar 1
  (closed-hhs )
  (sds        )
  (kicks      )
  )

;;(stop)
