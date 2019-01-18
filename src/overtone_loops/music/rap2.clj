(ns overtone-loops.music.rap2
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 404859))
(def hat (freesound2 404891))
(def hat2 (freesound2 404893))
(def clap (freesound2 24787))

;; Half beats                  1   &   2   &   3   &   4   &
(defloop ticks  (4 1/2) hat   [7   5   6   5   7   5   -   3 ])
(defloop hats   (4 1/2) hat2  [-   -   -   -   -   -   6   - ])

;; Quarter beats               1 a & e 2 a & e 3 a & e 4 a & e 
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
  
(do
  (ticks (on-next-bar 4))
  (hats (on-next-bar 4))
  (kicks (on-next-bar 4))
  (snares (on-next-bar 4))
  )

;;(stop)
