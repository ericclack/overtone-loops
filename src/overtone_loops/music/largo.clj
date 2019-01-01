(ns overtone-loops.music.largo
  (:use [overtone.live])
  (:require [overtone-loops.loops :refer [defphrase metro
                                          on-next-bar]]))

;; Define some instruments
(definst tone 
  "Sine tone that lasts about a second"
  [freq 440 amp 0.7 sustain 0.8]
  (let [env (env-gen (lin :sustain sustain :release 0.5) :action FREE)
        src (sin-osc freq)]
    (* amp env src)))

;; (tone 440 :sustain 0.1) 

(defn t
  ([note-name] (t note-name 0.5 0.8))
  ([note-name amp] (t note-name amp 0.8))
  ([note-name amp sus] 
   (tone (midi->hz (note note-name))
         amp
         sus)))

;; (t :c4)
;; (t :d4 0.4)


(metro-bpm metro 60)

(defphrase part1
  0 (t :b3 1)
  1 (t :c4)
  2 (t :d4)

  3 (t :g3 1)
  4 (t :f#3)
  5 (t :g3)

  6 (t :c4 1)
  7 (t :b3)
  7.5 (t :g3)
  8 (t :d4)
  8.5 (t :b3)

  9 (t :b3 1)
  10 (t :a3 0.8 2)
  ;;
  
  12 (t :g3 1)
  13 (t :g4)
  14 (t :f#4)
  14.5 (t :e4)

  15 (t :c#4 1)
  16 (t :d4)
  16.5 (t :a4)
  17 (t :e4)

  18 (t :f#4 1)
  18.4 (t :d4)
  19 (t :e4 0.8 2)
  ;;

  21 (t :d4 1 3)
  ;;
  ;;
  )

(part1 (metro))

;;
;;(stop)

