(ns overtone-loops.samples
  (:use [overtone.live]))

;; Drum loop as per tutorials

;; Define some samples from Freesound.org
(def kick (freesound 250547))
(def snare (freesound 270156))
(def hat (freesound 96140))

;; 
(def metro (metronome 128))

;; 
(defn player [beat]
  (at (metro beat) (kick))
  (at (metro (+ 0.5 beat)) (hat))

  (at (metro (+ 1 beat)) (kick))
  (at (metro (+ 1.5 beat)) (hat))

  (at (metro (+ 2 beat)) (snare))
  (at (metro (+ 2.5 beat)) (hat))

  (at (metro (+ 3.5 beat)) (hat))
  
  (apply-by (metro (+ 4 beat)) #'player (+ 4 beat) []))

(metro-bpm metro 120)
(player (metro))

;;
;(stop)

