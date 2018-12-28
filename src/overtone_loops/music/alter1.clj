(ns overtone-loops.music.alter1
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [clojure.pprint :refer [pp pprint]]
            [overtone-loops.loops :refer [defloop defloop2 metro
                                          on-next-bar]]))

;; Define some samples from Freesound.org
(def kick (freesound 171104))
(def snare (freesound 270156))
(def hat (freesound 404890))
(def crash (freesound 439789))
(def clap (freesound 24787))

(defloop2 hats1 1
  1 (hat :amp 0.5)
  )

(defloop2 crashes1 4
  2.4 (hat :amp 0.3)
  2.6 (hat :amp 0.5)
  2.8 (hat :amp 0.7)
  3 (crash :amp 0.4)
  )

(defloop2 kicks1 4
  0 (kick :amp 0.7)
  2 (kick :amp 0.6)
  ) 

(defloop2 extra-kicks 8
  4.5 (kick :amp 0.4)
  5.5 (kick :amp 0.4)
  )

(defloop2 snares1 4
  1 (clap :amp 0.6)
  3 (clap :amp 0.8)
  )

(defloop2 extra-snares 16
  2.5 (snare :amp 0.5)
  6.5 (snare :amp 0.5)
  
  12.6 (snare :amp 0.4)
  12.7 (snare :amp 0.5)
  12.8 (snare :amp 0.6)
  13 (snare :amp 0.8)  
  13.3 (snare :amp 0.4)
  13.5 (snare :amp 0.4)
  )


;; ---------------------------------------------

(metro-bpm metro 130)
  
(comment
  (hats1 (on-next-bar 4))
  (crashes1 (on-next-bar 4))
  )

(comment
  (kicks1 (on-next-bar 4))
  (extra-kicks (on-next-bar 8))
  )

(comment
  (snares1 (on-next-bar 8))
  (extra-snares (on-next-bar 8))
  )

;;(stop)
