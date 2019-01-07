(ns overtone-loops.proto.play-sample
  (:use [overtone.live]
        [overtone.inst.synth])
  (:require [overtone-loops.loops :refer [defloop metro
                                          on-next-bar]]))

;; Define some samples from Freesound.org
(def kick (freesound 56430))
(def stick0 (freesound 82280))
;; (stick0)
(def rim (freesound 34831))

(def stick-buf (load-sample (freesound-path 82280)))
(def chorus-buf (load-sample (freesound-path 213904)))

(definst chorus [amp 1 rate 1 release 0.01]
  (let [buf    chorus-buf
        dur    (/ (:duration buf) rate)
        env    (env-gen (lin 0.01
                             (- dur release 0.01)
                             release)
                        :action FREE)
        snd    (play-buf (:n-channels buf) buf rate)]
    (* amp env snd)))
;; (chorus :amp 1 :rate 0.5 :release 2)
;; (chorus :amp 1 :rate 0.5)

;; (chorus :amp 1 :rate 4 :release 1)


;; (stop)
