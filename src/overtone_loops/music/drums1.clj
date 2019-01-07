(ns overtone-loops.music.drums1
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [clojure.pprint :refer [pp pprint]]
            [overtone-loops.loops
             :refer [defloop on-next-bar metro]]))

;; Define some samples from Freesound.org
(def kick (freesound 171104))
(def snare (freesound 270156))
(def hat (freesound 404890))
(def crash (freesound 439789))
;; (crash)

(defloop ticks 4
  0 (hat :amp 0.4)
  1 (hat :amp 0.3)
  2 (hat :amp 0.4)
  3 (hat :amp 0.3)
  )
;;(defloop ticks 4)

(defloop hats1 4
  0.5 (hat :amp 0.7)
  1.5 (hat :amp 0.9)
  2.5 (hat :amp 0.9)
  3.5 (hat :amp 0.9)
  )
;;(defloop hats1 4)

(defloop crashes1 4
  3 (crash :amp 0.4)
  )

(defloop kicks1 4
  0 (kick :amp 0.6)
  1 (kick :amp 0.4)
  ;; 2 (kick :amp 0.4)
  3 (kick :amp 0.4)
  ) 

(defloop snares1 8
  2 (snare :amp 0.8)
  3.5 (snare :amp 0.4)
  6 (snare :amp 0.8)
  7.5 (snare :amp 0.4)
  )

(defloop extra-kicks 8
  4.75 (kick :amp 0.4)
  )

(defloop extra-snares 8
  5.75 (snare :amp 0.5)
  )


;; ---------------------------------------------

(metro-bpm metro 130)
  
(do
  (ticks (metro))
  (hats1 (metro))
  (kicks1 (metro))

  (crashes1 (on-next-bar 4 2))
  (snares1 (on-next-bar 8 4))
  )

(comment
  (extra-kicks (on-next-bar 4))
  (extra-snares (on-next-bar 4))
  )

;;(stop)
