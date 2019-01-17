(ns overtone-loops.music.rap1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 404859))
(def hat (freesound2 404891))
(def hat2 (freesound2 404893))
(def clap (freesound2 24787))

(defloop ticks  8 hat   [0.7 0.5 0.6 0.5 0.7 0.5 0.0 0.3])
(defloop hats   8 hat2  [0.0 0.0 0.0 0.0 0.0 0.0 0.6 0.0])

(defloop kicks  8 kick  [0.6  0   0   0  0.6  0   0   0 ])
(defloop snares 8 snare [0    0   0.7 0   0   0  0.9  0 ])

(defloop off-kicks 8
  1.7 (kick :amp 0.6)
  )

(defloop extra-kicks 8
  6 (kick :amp 0.5)
  6.7 (kick :amp 0.6)
  7 (kick :amp 0.9)
  )

(defloop extra-snares 8
  0.5 (snare :amp 0.5)
  3 (snare :amp 0.7)
  7.5 (snare :amp 0.5)
  )
;; (defloop2 snares 8) ; empty loop - silence

;; ---------------------------------------------

(bpm 210)
  
(do
  (ticks (on-next-bar 8))
  (hats (on-next-bar 8))
  (kicks (on-next-bar 8))
  (off-kicks (on-next-bar 8))
  (snares (on-next-bar 8))
  )

(comment ; all play for only 2-3 phrases
  (extra-kicks (on-next-bar 8) 2)
  (extra-snares (on-next-bar 8) 3)
  )

;;(stop)
