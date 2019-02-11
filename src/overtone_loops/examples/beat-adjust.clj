(ns overtone-loops.music.walk1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 404859))
(def hat (freesound2 404891))
(def hat2 (freesound2 404893))
(def ride-bell (freesound2 171482))

;; Quarter beats                    1 & 2 & 3 & 4 &   1 & 2 & 3 & 4 &  
(defloop kicks  (8 1/2) kick       [6 - - - 6 - - -   6 - - - 6 4 - -   ])
(defloop snares (4 1/2) snare      [- - 6 - - - 6 -   ])
(defloop hats   (4 1/2) hat        [- 6 - 6 4 6 - 6 ])

(defn late-halves
  "Play half beats a 1/6 beat late"
  [b]
  (if (half-beat? b) (+ b 1/6)
      b))

(defn early-halves
  "Play half beats a 1/6 beat early"
  [b]
  (if (half-beat? b) (- b 1/6)
      b))

(bpm 110)
(beats-in-bar 4)

(at-bar 1
        (kicks late-halves)
        (snares)
        (hats late-halves)
        )

;;(stop)
