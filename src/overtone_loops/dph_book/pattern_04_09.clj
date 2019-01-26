(ns overtone-loops.dph-book.pattern-04-09
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 270156))
(def kick (freesound2 171104))
(def ride-bell (freesound2 171482))
(def crash (freesound2 439789))
(def clap (freesound2 24787))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                     BAR1              
;;                     1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .  
(defloop closed-hhs
  (4 1/3) closed-hh   [8   3   6   8   3   6   8   3   6   8   3   6   ])
(defloop rides
  (4 1/3) ride-bell   [4   -   -   4   -   -   4   -   -   4   -   -   ])
(defloop sds
  (16 1/3) snare      [-   -   -   6   -   -   -   -   -   6   -   -     -   -   -   6   -   -   -   -   -   6   -   -     -   -   -   6   -   -   -   -   -   6   -   -     -   -   -   6   3   -   -   -   -   6   -   5    ])
(defloop kicks
  (16 1/6) kick       [8 - - - - - - - - - - - 8 - - 4 6 - - - - 5 - -   8 - - - - - - - - - 6 - 8 - - 7 - - - - - - - -   8 - - - 7 - - - - 4 5 - 8 - 7 8 - - - - - - -     8 - - 5 6 - - - - - 5 - 7 - - - - - - - - - - - ]) 
  
;; ---------------------------------------------

(bpm 98)
(beats-in-bar 4)
  
(at-bar 1
        (closed-hhs)
        (sds)
        (kicks)
  )

;;(stop)
