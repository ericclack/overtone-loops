(ns overtone-loops.examples.deflooplist
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def crash (freesound2 439789))
(def clap (freesound2 24787))

;; Lists of name, num-beats, instrument and amplitudes, 0=mute
(defloop hats   8 hat   [0    0.5  0    0.5  0    0.5   0    0.5])
(defloop kicks  8 kick  [0.7  0    0.2  0    0.7  0.6   0.2  0  ])
(defloop claps  4 clap  [0    0    1    0    ])

(defloop other-stuff 8
  0 (crash)
  5 (crash :rate 1.1)
  6 (crash :rate 1.2)
  )

;; ---------------------------------------------

(bpm 190)
  
(do
  (hats (on-next-bar 4))
  (kicks (on-next-bar 4))
  (claps (on-next-bar 4))
  (other-stuff (on-next-bar 4))
  )

;;(stop)

;; Variations
;;              name beats-in-bar         beat fn          beat fn
;; (defloop     hats 4                    0.5 (hat :amp 1) 1.5 (hat :amp 0.8))
;;
;; (deflooplist hats 4             instr  list)
