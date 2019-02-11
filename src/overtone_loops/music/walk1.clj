(ns overtone-loops.music.walk1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (sample2 "resources/samples/drum_bass_hard.wav"))
(def hat (freesound2 404891))
(def hat2 (freesound2 404893))
(def ride-bell (freesound2 171482))

;; Quarter beats                    1 e & a 2 e & a 3 e & a 4 e & a 
(defloop kicks  (16 1/4) kick       [6 - - - 6 - - - 6 - - - 6 - - -
                                     4 - 6 - 4 - 6 - 4 - 6 - 4 - - -
                                     6 - - - 6 - - - - - 6 - 6 - - -
                                     6 - 1 1 6 - 1 - 6 - 1 - 6 - 1 -])
(defloop hats   (4 1/4) hat         [- 4 6 - - 1 6 - - 4 6 - - 2 2 2])
(defloop rides  (8 1/4) ride-bell   [- - 4 - - - 3 - - - 3 - 4 - 3 -
                                     - - 2 - - - 2 - - - 3 1 - - 3 4
                                     ])

(defn early-beats
  "Make beats a bit earlier, randomly."
  [b]
  (- b (/ (rand) 10)))

(bpm 110)
(beats-in-bar 4)
(at-bar 1
        (kicks 4)
        (hats 16)
        )

(at-bar 5 
        (rides 2 early-beats)
        )

(at-bar 13
        (rides 2 early-beats)
        )

;;(stop)
