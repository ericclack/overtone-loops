(ns overtone-loops.examples.list-loops
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

;; Lists of name, num-beats, instrument and amplitudes, 0=mute
;;                             1         2         3          4
(defloop hats   (4 1/2) hat   [0    0.5  0    0.5  0    0.5   0    0.5])
(defloop kicks  (4 1/2) kick  [0.7  0    0.2  0    0.7  0.6   0.2  0  ])
(defloop claps  4       clap  [0         1         0          1       ])

(defloop other-stuff 8
  0 (crash)
  5 (crash :rate 0.9)
  6 (crash)
  )

;; ---------------------------------------------

(bpm 110)
(beats-in-bar 4)

(at-bar 1
  (hats )
  (kicks )
  (claps )
  (other-stuff )
  )

;;(stop)
