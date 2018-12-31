(ns overtone-loops.bass
  (:use [overtone.live])
  (:require [overtone-loops.loops :refer [defloop metro
                                          on-next-bar]]))

;; Define some instruments
(definst kick [freq 100 dur 0.3 width 0.5]
  (let [freq-env (* freq (env-gen (perc 0 (* 0.99 dur))))
        env (env-gen (perc 0.01 dur) 1 1 0 1 FREE)
        sqr (* (env-gen (perc 0 0.01)) (pulse (* 2 freq) width))
        src (sin-osc freq-env)
        drum (+ sqr (* env src))]
    (compander drum drum 0.2 1 0.1 0.01 0.01)))

(definst hat [amp 0.8 t 0.04]
  (let [env (env-gen (perc 0.001 t) 1 1 0 1 FREE)
        noise (white-noise)
        sqr (* (env-gen (perc 0.01 0.04)) (pulse 880 0.2))
        filt (bpf (+ sqr noise) 9000 0.5)]
    (* amp env filt)))

(definst tone
  "Simple sine tone that runs until stopped by gate 0"
  [freq 440 amp 0.7 gate 1]
  (let [env (env-gen (asr 0.2 1 1) :gate gate :action FREE)
        src (sin-osc freq)]
    (* amp env src)))

;;(tone 220)
;;(ctl tone :gate 0)
;;(stop)

(definst tone2 [freq 440 amp 0.7 sustain 1]
  "Sine tone that lasts about a second"
  (let [env (env-gen (lin :sustain sustain :release 0.5) :action FREE)
        src (sin-osc freq)]
    (* amp env src)))

;; (tone2 220 :sustain 0.1)

;; Our loops - both 4 beats to the bar
(defloop bass 4
  0 (kick)
  0.7 (kick)
  1 (kick 200)
  2 (kick)
  2.7 (kick)
  3 (kick 300)
  )

(defloop hats 4
  0 (hat 0.4)
  0.5 (hat)
  1 (hat 0.4)
  2 (hat 0.4)
  3 (hat 0.4)
  3.7 (hat)
  )

(defloop tones 4
  0 (tone :freq 220 :amp 0.3)
  1 (tone :freq 330)
  2 (tone :freq 440)
  3 (ctl tone :gate 0)
  
  3 (tone2 :freq 220 :amp 0.9)
  3.33 (tone2 :freq 250)
  3.66 (tone2 :freq 290)
  3.99 (tone2 :freq 220)

  )

(defloop low-tones 4
  0 (tone :freq 125 :amp 0.5)
  1 (tone :freq 128 :amp 0.5)
  2 (tone :freq 128 :amp 0.5)

  3.5 (ctl tone :gate 0)
  )

(metro-bpm metro 110)

(do
  (bass (metro))
  (hats (metro))
  )

;; Add these in when you like 
(comment
  (tones (on-next-bar 4) 8)
  (low-tones (on-next-bar 4) 8)
  )

;;
;;(stop)

