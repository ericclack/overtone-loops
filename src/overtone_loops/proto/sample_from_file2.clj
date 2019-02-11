(ns overtone-loops.proto.sample-from-file2
  (:use [overtone.live]
        [overtone.inst.synth]
        [overtone-loops.loops]))

(def boom (sample "resources/samples/bd_boom.wav"))

(boom)

;; (stop)
