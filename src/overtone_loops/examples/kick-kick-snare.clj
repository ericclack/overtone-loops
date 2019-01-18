(ns overtone-loops.examples.kick-kick-snare
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def finger (freesound2 177495))
(def clap (freesound2 24787))

;;                                1 & 2 & 3 & 4 &  5 & 6 & 7 & 8 &         
(defloop hats    (8 1/2) hat     [- 5 - 5 - 5 - 5  5 - - 5 5 - - 5])
(defloop snares  (8 1/2) snare   [- - - - 9 - - -  - - - - 6 3 9 -])
(defloop kicks   (8 1/2) kick    [9 - 9 - - - - -  9 5 9 5 - - - -])

;; ---------------------------------------------

(bpm 140)
  
(do
  (kicks (on-next-bar 4))
  (snares (on-next-bar 4))
  (hats (on-next-bar 4))
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  )

;;(stop)
