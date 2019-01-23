(ns overtone-loops.music.rap2
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 404859))
(def hat (freesound2 404891))
(def hat2 (freesound2 404893))
(def clap (freesound2 24787))

;; Half beats                   1   &   2   &   3   &   4   &
(defloop ticks  (4 1/2) hat    [7   5   6   5   7   5   -   3 ])
(defloop hats   (4 1/2) hat2   [-   -   -   -   -   -   6   - ])

;; Quarter beats                1 e & a 2 e & a 3 e & a 4 e & a 
(defloop snares (16 1/4) snare [- - - - 7 - - - - - - - 9 - - -
                                - - 5 - 7 - - - 7 - - - 9 - - 5
                                - - - - 7 - - 1 - 1 - - 9 - - -
                                - - 5 - 7 - - - 7 - - - 9 1 - 5
                               ])

(defloop kicks  (16 1/4) kick  [6 - - 6 - - - - 6 - - - - - - -
                                6 - - 6 - - - - 6 - - - - - - -
                                6 - - 6 - - - - 6 - 5 - 4 6 - -
                                6 - 1 6 - 1 - 1 6 - 5 1 4 6 1 1                               
                               ])

;; ---------------------------------------------

(bpm 105)
(beats-in-bar 4)

(at-bar 1
        (ticks )
        (hats )
        (kicks )
        (snares )
  )

(comment
  ;; All samples in this file use stereo player
  (inst-pan! my-mono-sample-player -0.7)
  (inst-pan! my-stereo-sample-player 0.5)
  
  (inst-volume! my-mono-sample-player 1)
  (inst-volume! my-stereo-sample-player 0.5)
  
  )

;;(stop)
