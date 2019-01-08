(ns overtone-loops.proto.play-sample
  (:use [overtone.live]
        [overtone.inst.synth])
  (:require [overtone-loops.loops :refer [defloop metro
                                          on-next-bar
                                          freesound2]]))

;; Define some samples from Freesound.org
(def kick (freesound2 56430))
(def stick (freesound2 82280))
(def rim (freesound2 34831))

;; (chorus)
;; (chorus :amp 1 :rate 0.5 :release 2)
;; (chorus :amp 1 :rate 0.5)
;; (chorus :amp 1 :rate 4 :release 3)
;; (rim)
;; (stick)
;; (kick)

;; (stop)
