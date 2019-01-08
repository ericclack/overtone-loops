(ns overtone-loops.proto.play-sample
  (:use [overtone.live]
        [overtone.inst.synth])
  (:require [overtone-loops.loops :refer [defloop metro
                                          on-next-bar
                                          freesound2]]))

;; Define some samples from Freesound.org
(def kick (freesound2 56430))
(def rim (freesound2 34831))
(def chorus (freesound2 213904))

;; (chorus :amp 1 :rate 0.5 :release 2)
;; (chorus :amp 1 :rate 0.5)

;; (chorus :amp 1 :rate 4 :release 3)
;; (chorus :rate 1.5)


;; Compare default player with our one
(def stick (freesound 82280))
(def stick2 (freesound2 82280))

;; (stick)
;; (stick2)

;; More tests
(def chorus-buf (load-sample (freesound-path 213904)))

;; (stop)
