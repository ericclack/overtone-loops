(ns overtone-loops.music.amen1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def openhat (freesound2 317094))
(def crash (freesound2 439789))

(defloop hats1 4
  0 (hat :amp 0.2)
  0 (openhat :amp 0.3 :rate 0.6)
  
  1 (hat :amp 0.2)
  1 (openhat :amp 0.3 :rate 0.6)

  2 (hat :amp 0.2)
  2 (openhat :amp 0.3 :rate 0.6)

  3 (hat :amp 0.2)
  )

(defloop kicks1 8
  0 (kick :amp 0.7)
  1 (kick :amp 0.7)

  5 (kick :amp 0.3)
  5.5 (kick :amp 0.4)
  ) 

(defloop snares1 8
  2 (snare :amp 0.7 :rate 0.8)

  3.5   (snare :amp 0.3 :rate 0.8)
  4.5   (snare :amp 0.3 :rate 0.8)

  6     (snare :amp 0.3 :rate 0.8)
  7.5   (snare :amp 0.7 :rate 0.8)
  )

;; ---------------------------------------------

(bpm 220)

;; Eval these with Ctrl-X Ctrl-E

(do
  (hats1 (on-next-bar 8))
  (kicks1 (on-next-bar 8))
  (snares1 (on-next-bar 8))
  )

;;(stop)
