(ns overtone-loops.music.sticks1
  (:use [overtone.live])
  (:require [overtone-loops.loops :refer [defloop metro
                                          on-next-bar]]))

;; Define some samples from Freesound.org
(def kick (freesound 56430))
(def stick (freesound 82280))
(def rim (freesound 34831))

;; Add envelopes to some of the samples
(definst stick1
  [amp 0.7]
  (let [env     (env-gen (perc 0.01 1) :action FREE)
        snd     (play-buf 1 stick)]
    (* amp env snd)))

(stick1)

(defloop sticks 4
  0 (stick1 0.8)
  1.8 (stick1 0.7)
  2.5 (stick1 0.7)
  3.5 (stick1 0.7)
  )

(defloop kicks 1
  0 (kick :amp 1)
  )

(defloop extra-sticks 1
  0 (rim :amp 0.5)
  0.7 (rim)
  )

;; ---------------------------------------------

(metro-bpm metro 85)
  
(do
  (sticks (on-next-bar 4))
  (kicks (on-next-bar 4))
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (extra-sticks (on-next-bar 4) 8)
  )

;;(stop)
