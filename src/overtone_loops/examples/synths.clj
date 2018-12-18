(ns overtone-loops.bass
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [overtone-loops.loops :refer [defloop metro thunk]]))

;; Define some instruments
(def flute (freesound 35809))

;; Our loops - both 4 beats to the bar
(flute :rate 1 :loop? true)

(piano 60)
(piano 64)
(piano 67)

(metro-bpm metro 110)

(demo 10 (buf-rd 2 flute (* (sin-osc 0.1) (buf-frames flute))))

(demo 10 (buf-rd 2 flute (* (lf-noise1 1) (buf-frames flute))))
(demo 10 (buf-rd 2 flute (* (lf-noise1 10) (buf-frames flute))))

(demo 10 (buf-rd 2 flute (+ (lf-tri 1.1) (*  (lin-lin (lf-tri 0.23) -1 1 0 1) (buf-frames flute)))))


;;
;;(stop)

