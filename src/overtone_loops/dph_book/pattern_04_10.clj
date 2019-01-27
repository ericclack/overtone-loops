(ns overtone-loops.dph-book.pattern-04-10
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def open-hh (freesound2 404893))
(def pedal-hh (freesound2 93910))
(def snare (freesound2 404859))
(def kick (freesound2 171104))
(def ride-bell (freesound2 171482))
(def crash (freesound2 439789))
(def clap (freesound2 24787))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                    BAR1              
;;                    1 e & a 2 e & a 3 e & a 4 e & a
;;                    v       v       v       v 
(defloop open-hhs
  (4 1/4) open-hh    [- - 6 - - - 6 - - - 6 - - - 6 -  ])
(defloop closed-hhs
  (4 1/4) closed-hh  [- - - - - - - - - - - - - - - -  ])
(defloop ped-hhs
  (4 1/4) pedal-hh   [3 - - - 3 - - - 3 - - - 3 - - -  ])
(defloop sds
  (4 1/4) snare      [- - - - 8 - - - - - - - 8 - - -  ])                       
(defloop kicks
  (4 1/4) kick       [8 - - - - - - - 7 - 7 - - - - -  ])
                      
(defphrase fade-out
  0  (inst-volume! stereo-sample-player 0.8)
  1  (inst-volume! stereo-sample-player 0.7)
  2  (inst-volume! stereo-sample-player 0.6)
  3  (inst-volume! stereo-sample-player 0.5)
  4  (inst-volume! stereo-sample-player 0.4)
  5  (inst-volume! stereo-sample-player 0.3)
  6  (inst-volume! stereo-sample-player 0.1)
  7  (inst-volume! stereo-sample-player 0)
  8  (stop)
  )

;; ---------------------------------------------

(bpm 100)
(beats-in-bar 4)
(inst-volume! stereo-sample-player 1)

(at-bar 1
        (open-hhs)
        (ped-hhs)
        (sds)
        (kicks)
  )

(comment
  (fade-out (metro))
  )

;;(stop)
