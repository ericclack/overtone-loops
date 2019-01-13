(ns overtone-loops.examples.kick-kick-snare
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def finger (freesound2 177495))
(def clap (freesound2 24787))

;;                           1         2         3         4     //   5           6                      7           8         
(defloop kicks   8 kick    [ 1.0       1.0       0.0       0.5        (1.0 0.5)   1.0                    0.0         0.0    ])
(defloop snares  8 snare   [ 0.0       0.0       0.3       0.0        0.3        (0.2 0.3 0.4 0.5 0.7)   0.8         1.0    ])
(defloop hats    8 hat     [(0 0.5)   (0 0.5)   (0 0.5)   (0 0.5)     0.5         0.5                   (0 0.5)     (0 0.5) ])

;; ---------------------------------------------

(bpm 140)
  
(do
  (kicks (on-next-bar 4))
  (snares (on-next-bar 4))
  (hats (on-next-bar 4))
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  )

;;(stop)
