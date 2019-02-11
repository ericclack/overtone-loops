(ns overtone-loops.music.rap1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Define some samples from Freesound.org
(def hat (freesound2 404891))
(def hat2 (freesound2 404893))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                                           0 1 2 3 4 5 6 7
;;                                           1 & 2 & 3 & 4 &
(defloop ticks        (4 1/2) cymbal-closed  [7 5 6 5 7 5 - 3 ])
(defloop hats         (4 1/2) hat2           [- - - - - - 6 - ])

(defloop kicks        (4 1/2) bass-hard      [6 6 - - 6 - - - ])
(defloop snares       (4 1/2) snare-hard     [- - 7 - - - 9 - ])

(defloop extra-kicks  (4 1/2) bass-hard      [- - - - - 5 - 6 ])
(defloop extra-snares (4 1/2) snare-hard     [- 2 - 7 - - - 3 ])

;;

(defn late-halves
  "Play half beats a bit late"
  [b]
  (if (half-beat? b) (+ b 1/3)
      b))

;; ---------------------------------------------

(bpm 105)
(beats-in-bar 4)

(at-bar 1
        (ticks)
        (hats )
        (kicks late-halves)
        (snares )
  )

(comment ; all play for only 2-3 phrases
  (extra-kicks (on-next-bar) 2 late-halves)
  (extra-snares (on-next-bar) 3)
  )

;;(stop)
