(ns overtone-loops.samples
  (:use [overtone-loops.loops]))

;; Define local samples & some freesound placeholders -- until
;; we replace them with local ones

(def cowbell (sample2 "resources/samples/drum_cowbell.wav")) ;; (cowbell)
(def clap (sample2 "resources/samples/perc_clap.wav")) ;; (clap)
(def crash (freesound2 439789)) ;; (crash)

(def cymbal-open (sample2 "resources/samples/drum_cymbal_open.wav")) ;; (cymbal-open)
(def cymbal-closed (sample2 "resources/samples/drum_cymbal_closed.wav"))  ;; (cymbal-closed)
(def hatc2 (freesound2 404890)) ;; closed ;; (hatc2)
(def hatc3 (freesound2 96140))  ;; (hat3)
(def cymbal-pedal (sample2 "resources/samples/drum_cymbal_pedal.wav")) ;; (cymbal-pedal)
(def cymbal-soft (sample2 "resources/samples/drum_cymbal_soft.wav")) ;; (cymbal-soft)

(def bass-hard (sample2 "resources/samples/drum_bass_hard.wav")) ;; (bass-hard)
(def bass-soft (sample2 "resources/samples/drum_bass_soft.wav")) ;; (bass-soft)

(def ride (sample2 "resources/samples/drum_ride.wav")) ;; (ride)
(def ride-bell (sample2 "resources/samples/drum_ride_bell.wav")) ;; (ride-bell)
(def rim (sample2 "resources/samples/drum_rim.wav")) ;; (rim)

(def snare-hard (sample2 "resources/samples/drum_snare_hard.wav")) ;; (snare-hard :amp 0.2)
(def snare-soft (sample2 "resources/samples/drum_snare_soft.wav")) ;; (snare-soft)

(def tom-hi-hard (sample2 "resources/samples/drum_tom_hi_hard.wav")) ;; (tom-hi-hard)
(def tom-mid-hard (sample2 "resources/samples/drum_tom_mid_hard.wav")) ;; (tom-mid-hard)
(def tom-lo-hard (sample2 "resources/samples/drum_tom_lo_hard.wav")) ;; (tom-lo-hard)
  
;; Snaps etc
(def finger (freesound2 177495)) ;; (finger)
(def stick (freesound2 82280)) ;; (stick)
