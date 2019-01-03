(ns overtone-loops.music.amen1
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [clojure.pprint :refer [pp pprint]]
            [overtone-loops.loops :refer [defloop metro
                                          on-next-bar]]))

;; Define some samples from Freesound.org
(def kick (freesound 171104))
(def snare (freesound 270156))
(def hat (freesound 404890))
(def openhat (freesound 317094))
(def crash (freesound 439789))
;; (crash)

(defloop hats1 8
  0 (openhat :amp 0.5)
  1 (openhat :amp 0.6)
  2 (openhat :amp 0.7)

  4 (openhat :amp 0.5)
  5 (openhat :amp 0.6)
  6 (openhat :amp 0.7)
  7 (openhat :amp 0.4)  
  )

(defloop kicks1 8
  0 (kick :amp 0.7)
  1 (kick :amp 0.8)

  5 (kick :amp 0.4)
  6 (kick :amp 0.9)
  ) 

(defloop extra-kicks 8
  )

(defloop snares1 8
  2 (snare :amp 0.7)

  5.5 (snare :amp 0.7)
  6.5 (snare :amp 0.7)
  7.5 (snare :amp 0.5)
  )

(defloop extra-snares 8
  )


;; ---------------------------------------------

(metro-bpm metro 240)

;; Eval these with Ctrl-X Ctrl-E

(comment
  (hats1 (on-next-bar 8))
  )

(comment
  (kicks1 (on-next-bar 8))
  (extra-kicks (on-next-bar 8))
  )

(comment
  (snares1 (on-next-bar 8))
  (extra-snares (on-next-bar 8))
  )

;;(stop)
