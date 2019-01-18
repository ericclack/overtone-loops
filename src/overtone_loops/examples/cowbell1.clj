(ns overtone-loops.examples.cowbell1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def hat (freesound2 404890))
(def crash (freesound2 439789))
(def clap (freesound2 24787))
(def bell (freesound2 382806))

;; Lists of name, beat-pattern, instrument and amplitudes, 0=mute
;; beat-pattern is either an int = number of beats in a bar
;; or a pair of (beats-in-bar beat-value)

;;                              1 & 2 & 3 & 4 & 
(defloop hats   (4 1/2) hat    [- 5 - 5 - 5 - 5 ])

(defloop kicks  (16 1/2) kick  [7 - 2 - 7 - 2 -  7 - 2 - 7 - 2 -  7 - 2 - 7 6 2 -  7 - 2 - 7 6 2 - ])
(defloop claps  (16 1/2) clap  [- - - - 3 - - -  - - - - 3 - - -  - - - - 4 - - -  - - - - - 4 - 6 ])

;; Thirds                       1 and  2 and  3 and  4 and
(defloop bells  (16 1/3) bell   [4 - -  4 - -  4 - - 4 6 4
                                 4 - -  - - 4  - 6 - - 5 7
                                 4 - -  - - 4  - 6 - - 5 7
                                 4 - -  - - 4  - 6 - - 5 7 ])

;; ---------------------------------------------

(bpm 110)
  
(do
  (hats (on-next-bar 4))
  (kicks (on-next-bar 4))
  (claps (on-next-bar 4))
  (bells (on-next-bar 4 5))
  )

;;(stop)
