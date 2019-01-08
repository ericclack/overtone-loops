(ns overtone-loops.music.rap1
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [clojure.pprint :refer [pp pprint]]
            [overtone-loops.loops :refer [defloop metro
                                          on-next-bar
                                          freesound2]]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 404859))
(def hat (freesound2 404891))
(def hat2 (freesound2 404893))
(def clap (freesound2 24787))

(defloop ticks 8
  0 (hat :amp 0.7)
  1 (hat :amp 0.5)
  2 (hat :amp 0.7)
  3 (hat :amp 0.5)
  4 (hat :amp 0.7)
  5 (hat :amp 0.5)
  6 (hat2 :amp 0.6)
  7 (hat :amp 0.3)
  )

(defloop kicks 8
  0 (kick :amp 0.6)
  1.7 (kick :amp 0.6)
  4 (kick :amp 0.6)
  )
;; (defloop2 kicks 8) ; empty loop - silence

(defloop extra-kicks 8
  6 (kick :amp 0.5)
  6.7 (kick :amp 0.6)
  7 (kick :amp 0.9)
  )

(defloop snares 8
  2 (snare :amp 0.7)
  6 (snare :amp 0.9)
  )
;; (defloop2 snares 8) ; empty loop - silence

(defloop extra-snares 8
  0.5 (snare :amp 0.5)
  3 (snare :amp 0.7)
  7.5 (snare :amp 0.5)
  )
;; (defloop2 snares 8) ; empty loop - silence

;; ---------------------------------------------

(metro-bpm metro 210)
  
(do
  (ticks (on-next-bar 8))
  (kicks (on-next-bar 8))
  (snares (on-next-bar 8))
  )

(comment ; all play for only 2-3 phrases
  (extra-kicks (on-next-bar 8) 2)
  (extra-snares (on-next-bar 8) 3)
  )

;;(stop)
