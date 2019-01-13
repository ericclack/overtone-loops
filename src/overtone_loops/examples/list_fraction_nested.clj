(ns overtone-loops.examples.list-fraction-nested
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def hat (freesound2 404890))
(def crash (freesound2 439789))
(def clap (freesound2 24787))
(def bell (freesound2 382806))

;; Lists of name, beat-pattern, instrument and amplitudes, 0=mute
;; And amp is either a single value, and is played on the beat,
;; or a list of values that are played as fractions of that beat.

;;                           1        2          3               4
(defloop hats    4  hat    [(0.0 0.5)  (0.0 0.5)    (0.0 0.5)   (0.0 0.5)]) ;; off beats
(defloop kicks   4  kick   [ 0.7        0.2         (0.7 0.6)    0.2     ]) ;; one pair
(defloop claps   4  clap   [ 0          0            0.7         0       ]) ;; regular beats
(defloop bells   4  bell   [ 0.4       (0.0 0 0.4)  (0 0.6 0.7)  0.8     ]) ;; triplets

;; ---------------------------------------------

(bpm 130)
  
(do
  (hats (on-next-bar 4))
  (kicks (on-next-bar 4))
  (claps (on-next-bar 4))
  (bells (on-next-bar 4))
  )

;;(stop)
