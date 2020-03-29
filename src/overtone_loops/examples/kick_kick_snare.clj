(ns overtone-loops.examples.kick-kick-snare
  (:use [overtone.live]
        [overtone-loops.loops]))

(set-up)

;; Define some samples from Freesound.org
(def kick (freesound2 250547))
(def snare (freesound2 270156))
(def hat (freesound2 96140))

(bpm 140)
(beats-in-bar 4)

;;                           1 & 2 & 3 & 4 &
(defloop kicks  1/2 kick    [8 _ 7 _ _ _ _ _])
(defloop snares 1/2 snare   [_ _ _ _ 8 _ _ _])
(defloop hats   1/2 hat     [_ 5 _ 5 _ 5 _ 5])

(kicks (metro))
(snares (metro))
(hats (metro))

;;(stop)
