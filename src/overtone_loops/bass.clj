(ns overtone-loops.bass
  (:use [overtone.live])
  (:require [overtone-loops.loops :refer [defloop metro]]))

;; Define some instruments
(definst kick [freq 100 dur 0.3 width 0.5]
  (let [freq-env (* freq (env-gen (perc 0 (* 0.99 dur))))
        env (env-gen (perc 0.01 dur) 1 1 0 1 FREE)
        sqr (* (env-gen (perc 0 0.01)) (pulse (* 2 freq) width))
        src (sin-osc freq-env)
        drum (+ sqr (* env src))]
    (compander drum drum 0.2 1 0.1 0.01 0.01)))

(defn kick2 [] (kick 200))
(defn kick3 [] (kick 90 0.5))

(definst hat [amp 0.8 t 0.04]
  (let [env (env-gen (perc 0.001 t) 1 1 0 1 FREE)
        noise (white-noise)
        sqr (* (env-gen (perc 0.01 0.04)) (pulse 880 0.2))
        filt (bpf (+ sqr noise) 9000 0.5)]
    (* amp env filt)))

;; Our loops - both 4 beats to the bar
(defloop bass 4
  0 kick
  0.7 kick
  1 kick2
  2 kick
  2.7 kick
  3 kick3 
  )

(defloop hats 4
  0.5 hat
  1.5 hat
  2.5 hat
  3.5 hat
  )

(metro-bpm metro 90)
(bass (metro))
(hats (metro))

;;
;;(stop)

