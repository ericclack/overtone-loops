(ns overtone-loops.music.alter1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def crash (freesound2 439789))
(def clap (freesound2 24787))

;; We want to use amps between 0 and 1 in our lists
(amp-scale 1)

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

(bpm 130)
(beats-in-bar 4)

(at-bar 1
  (hats )
  (claps )
  (kicks )
  (crashes1 )
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (exkicks (on-next-bar) 4)
  (extra-snares (on-next-bar) 8)
  )

;;(stop)
