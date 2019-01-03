(ns overtone-loops.music.sticks1
  (:use [overtone.live]
        [overtone.inst.synth])
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

(defloop sticks 4
  0 (stick1 0.8)
  1 (stick1 0.6)  
  1.8 (stick1 0.6)
  2.5 (stick1 0.6)
  3.2 (stick1 0.6)
  )

;; (sticks (metro))

(defloop kicks 4
  0 (kick :amp 1)
  1 (kick :amp 1)
  2 (kick :amp 1)
  3 (kick :amp 1)
  )

(defloop bass-line 4
  ;;0 (overpad (note :c3))
  )

;; (ctl vintage-bass :gate 0)
(defloop extra-sticks 1
  0 (rim :amp 0.5)
  0.7 (rim)
  )

;; ---------------------------------------------

(metro-bpm metro 85)
  
(do
  (sticks (on-next-bar 4))
  (kicks (on-next-bar 4))
  (bass-line (on-next-bar 4 2))
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (extra-sticks (on-next-bar 4) 8)
  )

;;(stop)
