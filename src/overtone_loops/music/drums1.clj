(ns overtone-loops.music.drums1
  (:use [overtone.live]
        [overtone-loops.loops]))
  
;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def crash (freesound2 439789))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                               1 & 2 & 3 & 4 & 5 & 6 & 7 & 8 & 
(defloop ticks     4      hat   [4   3   4   3  ])
(defloop hats1    (4 1/2) hat   [- 7 - 9 - 9 - 9])
(defloop crashes1  8      crash [-   -   4   -   -   -   -   -])

(defloop kicks1   (8 1/2) kick  [6 - 4 - - - 4 - 6 - 4 - - - 4 -])
(defloop snares1  (8 1/2) snare [- - - - 6 - - 3 - - - 1 6 1 - 3])

(defloop extra-kicks 8
  4.75 (kick :amp 0.4)
  )

(defloop extra-snares 8
  5.75 (snare :amp 0.5)
  )


;; ---------------------------------------------

(bpm 130)
(beats-in-bar 4)
  
(at-bar 1
  (ticks)
  (hats1)
  (kicks1)
  )

(at-bar 1
  (crashes1)
)

(at-bar 3
  (snares1)
  )

(comment
  (extra-kicks (on-next-bar))
  (extra-snares (on-next-bar))
  )

;;(stop)
