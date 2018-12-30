(ns overtone-loops.music.alter1
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [clojure.pprint :refer [pp pprint]]
            [overtone-loops.loops :refer [defloop metro
                                          on-next-bar]]))

;; Define some samples from Freesound.org
(def kick (freesound 171104))
(def snare (freesound 270156))
(def hat (freesound 404890))
(def crash (freesound 439789))
(def clap (freesound 24787))

(defloop hats1 1
  1 (hat :amp 0.5)
  )

(defloop crashes1 8
  2.2 (hat :amp 0.3)
  2.6 (hat :amp 0.5)
  2.8 (hat :amp 0.7)
  3 (crash :amp 0.4)
  )

(defloop kicks1 4
  0 (kick :amp 0.7)
  2 (kick :amp 0.6)
  ) 

(defloop extra-kicks 8
  4.5 (kick :amp 0.4)
  5.5 (kick :amp 0.4)
  )

(defloop snares1 4
  1 (clap :amp 0.6)
  3 (clap :amp 0.8)
  )

(defloop extra-snares 16
  2.5 (snare :amp 0.8)
  3 (snare :amp 0.5)
  3.5 (snare :amp 0.2)
  
  6.5 (snare :amp 0.8)
  7 (snare :amp 0.5)
  7.5 (snare :amp 0.2)
  
  12.6 (snare :amp 0.4)
  12.7 (snare :amp 0.5)
  12.8 (snare :amp 0.6)
  13 (snare :amp 0.8)  
  13.3 (snare :amp 0.4)
  13.5 (snare :amp 0.4)
  14 (snare :amp 0.7)
  )


;; ---------------------------------------------

(metro-bpm metro 130)
  
(do
  (hats1 (on-next-bar 4))
  (crashes1 (on-next-bar 4))
  (snares1 (on-next-bar 4))
  (kicks1 (on-next-bar 4))
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (extra-kicks (on-next-bar 8) 4)
  (extra-snares (on-next-bar 8) 8)
  )

;;(stop)
