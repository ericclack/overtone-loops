(ns overtone-loops.samples
  (:use [overtone-loops.loops]))

;; Define local samples & some freesound placeholders -- until
;; we replace them with local ones

(def bell (freesound2 382806)) ;; (bell)
(def clap (freesound2 24787)) ;; (clap)
(def crash (freesound2 439789)) ;; (crash)

(def cymbal-open (sample2 "resources/samples/drum_cymbal_open.wav")) ;; (cymbal-open)
(def cymbal-closed (sample2 "resources/samples/drum_cymbal_closed.wav"))  ;; (hatc)
(def hatc2 (freesound2 404890)) ;; closed ;; (hatc2)
(def hatc3 (freesound2 96140))  ;; (hat3)
(def cymbal-pedal (sample2 "resources/samples/drum_cymbal_pedal.wav")) ;; (cymbal-pedal)

(def bass-hard (sample2 "resources/samples/drum_bass_hard.wav")) ;; (bass-hard)
(def kickelec (freesound2 250547)) ;; (kickelec)
(def kicksoft (freesound2 56430)) ;; (kicksoft)

(def open-hh (freesound2 404893)) ;; (open-hh)
(def openhat (freesound2 317094)) ;; (openhat)
(def pedal-hh (freesound2 93910)) ;; (pedal-hh)

(def ride (freesound2 162311)) ;; (ride)
(def ride-bell (freesound2 171482)) ;; (ride-bell)
(def rim (freesound2 34831)) ;; (rim)

(def snare-hard (sample2 "resources/samples/drum_snare_hard.wav")) ;; (snare-hard)
(def snare2 (freesound2 404859)) ;; (snare2)

;; Snaps etc
(def finger (freesound2 177495)) ;; (finger)
(def stick (freesound2 82280)) ;; (stick)
