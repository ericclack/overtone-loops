(ns overtone-loops.proto.sample-from-file2
  (:use [overtone.live]
        [overtone.inst.synth]
        [overtone-loops.loops]))

(def boom1 (sample "resources/samples/drum_bass_hard.wav"))
(def boom2 (sample2 "resources/samples/drum_bass_hard.wav"))

(comment
  ;; This clicks for some samples!
  (boom1)
  
  ;; This doesn't
  (boom2)
  )

;; (stop)
