(ns overtone-loops.music.alter1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def crash (freesound2 439789))
(def clap (freesound2 24787))

;;                                1         2         3         4          5         6         7         8
(defloop hats     2       hat    [0         0.5 ])
(defloop kicks   (4 1/2) kick    [0.7  0.0  0.0  0.0  0.2  0.0  0.0  0.0  ])
(defloop claps    4      clap    [0.0       0.6       0.0       0.8       ])

(defloop exkicks (8 1/2) kick    [0.0  0.0  0.0  0.0  0.0  0.0  0.0  0.0   0.0  0.4  0.0  0.4  0.0  0.0  0.0])

(defloop crashes1 8
  2.2 (hat :amp 0.3)
  2.6 (hat :amp 0.5)
  2.8 (hat :amp 0.7)
  3 (crash :amp 0.4)
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
  (hats (on-next-bar 4))
  (claps (on-next-bar 4))
  (kicks (on-next-bar 4))
  (crashes1 (on-next-bar 4))
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (exkicks (on-next-bar 8) 4)
  (extra-snares (on-next-bar 8) 8)
  )

;;(stop)
