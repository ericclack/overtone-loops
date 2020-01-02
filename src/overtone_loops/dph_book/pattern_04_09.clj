(ns overtone-loops.dph-book.pattern-04-09
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 404859))
(def kick (freesound2 171104))
(def ride-bell (freesound2 171482))
(def crash (freesound2 439789))
(def clap (freesound2 24787))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;           BAR1              
;;           1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .  
(defloop closed-hhs 1/6
  closed-hh [8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _   8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _   8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _   8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _
                       8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 4 3 _ 6 _ 8 _ 3 _ 6 _   8 4 3 _ 6 _ 8 4 6 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _   8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _   8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _ 8 _ 3 _ 6 _ ])
(defloop sds 1/6
  snare     [_ _ _ _ _ _ 7 _ _ _ _ _ _ _ _ _ _ _ 7 _ _ _ _ _   _ _ _ _ _ _ 7 _ _ _ _ _ _ _ _ _ _ _ 7 _ _ _ _ _   _ _ _ _ _ _ 7 _ _ _ _ _ _ _ _ _ _ _ 6 _ _ _ _ _   _ _ _ _ _ _ 6 _ 3 _ _ _ _ _ _ _ _ _ 6 _ _ _ 5 _
                       _ _ _ _ _ _ 7 _ _ _ _ _ _ _ _ 3 _ _ 7 _ _ _ _ _   _ _ _ _ _ _ 7 _ _ _ _ _ _ _ _ 3 _ _ 7 _ _ _ 5 _   _ _ _ 3 _ _ 7 _ _ _ _ _ _ _ _ _ _ _ 6 _ _ 4 _ _   _ _ _ _ _ 7 4 _ _ _ _ _ _ _ 3 _ _ _ 7 _ 4 _ 3 _ ])
                       
(defloop kicks 1/6
  kick      [8 _ _ _ _ _ _ _ _ _ _ _ 8 _ _ 4 6 _ _ _ _ 5 _ _   8 _ _ _ _ _ _ _ _ _ 6 _ 8 _ _ 7 _ _ _ _ _ _ _ _   8 _ _ _ 7 _ _ _ _ 4 5 _ 8 _ 7 8 _ _ _ _ _ _ _ _   8 _ _ 5 6 _ _ _ _ _ 5 _ 7 _ _ _ _ _ _ _ _ _ _ _
                       8 _ _ _ _ _ _ _ _ 6 8 _ _ _ _ _ 7 8 _ _ _ _ 6 _   8 _ _ _ 7 _ _ _ _ _ 6 _ _ _ _ _ 7 _ _ _ _ 5 _ _   8 _ _ _ 7 _ _ _ 7 _ _ _ 8 _ _ 7 _ 8 _ _ _ _ 8 _   8 _ 7 _ _ _ _ 3 5 _ 8 _ _ _ _ 6 _ 8 _ _ _ _ _ _ ]) 

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

(bpm 98)
(beats-in-bar 4)
(inst-volume! stereo-sample-player 1)

(at-bar 1
        (closed-hhs)
        (sds)
        (kicks)
  )

(comment
  (fade-out (metro))
  )

;;(stop)
