(ns overtone-loops.music.largo
  (:use [overtone.live])
  (:require [overtone-loops.loops :refer [defphrase metro
                                          on-next-bar]]))

;; Define some instruments
(definst tone2
  "Simple sine tone that runs until stopped by gate 0"
  [freq 440 amp 0.7 gate 1]
  (let [env (env-gen (asr 0.2 1 1) :gate gate :action FREE)
        src (sin-osc freq)]
    (* amp env src)))

;;(tone 220)
;;(ctl tone :gate 0)
;;(stop)

(definst tone 
  "Sine tone that lasts about a second"
  [freq 440 amp 0.7 sustain 1]
  (let [env (env-gen (lin :sustain sustain :release 0.5) :action FREE)
        src (sin-osc freq)]
    (* amp env src)))

;; (tone 440 :sustain 0.1)

(defn t [note-name]
  (tone (midi->hz (note note-name))))

;; (t :c4)
;; (t :d4)


(metro-bpm metro 60)

(defphrase part1
  0 (t :b3)
  1 (t :c4)
  2 (t :d4)

  3 (t :g3)
  4 (t :f#3)
  5 (t :g3)

  6 (t :c4)
  7 (t :b3)
  7.5 (t :g3)
  8 (t :d4)
  8.5 (t :b3)

  9 (t :b3)
  10 (t :a3)
  ;;
  
  12 (t :g3)
  11 (t :g4)
  12 (t :f#4)
  12.5 (t :e4)
  )

(part1 (metro))

;;
;;(stop)

