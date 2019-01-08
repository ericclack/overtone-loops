(ns overtone-loops.music.amen1
  (:use [overtone.live]
        [overtone.inst.piano]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def openhat (freesound2 317094))
(def crash (freesound2 439789))

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

(do
  (hats1 (on-next-bar 8))
  (kicks1 (on-next-bar 8))
  (snares1 (on-next-bar 8))
  )

(comment
  (extra-kicks (on-next-bar 8))
  (extra-snares (on-next-bar 8))
  )

;;(stop)
