(ns overtone-loops.examples.deflooplist
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def crash (freesound2 439789))
(def clap (freesound2 24787))

(deflooplist hats   4 hat   [0    0.5  0    0.5  ])
(deflooplist kicks  4 kick  [0.7  0    0.2  0    ])
(deflooplist claps  4 clap  [0    0    1    0    ])

;; ---------------------------------------------

(bpm 190)
  
(do
  (hats (on-next-bar 4))
  (kicks (on-next-bar 4))
  (claps (on-next-bar 4))
  )

;;(stop)
