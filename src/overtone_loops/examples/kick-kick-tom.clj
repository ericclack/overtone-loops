(ns overtone-loops.examples.kick-kick-snare
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def tom (freesound2 86331))
(def finger (freesound2 177495))
(def clap (freesound2 24787))

;;                           1         2         3         4     //   5           6         7           8         
(defloop kicks   8 kick    [ 0.9       0.7       0.0       0.0        0.9         0.7      0.0         0.0    ])
(defloop toms    8 tom     [ 0.0       0.0       0.7       0.0        0.0         0.0      0.8         0.0    ])
(defloop hats    8 hat     [ 0.5       0.5       0.5    (0 0.5)     0.5         0.5      (0 0.5)     (0 0.5) ])

;; ---------------------------------------------

(bpm 170)
  
(do
  (kicks (on-next-bar 4))
  (toms (on-next-bar 4))
  (hats (on-next-bar 4))
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  )

;;(stop)
