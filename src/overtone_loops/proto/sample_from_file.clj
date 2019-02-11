(ns overtone-loops.proto.sample-from-file
  "Load a sample from a file and return a player function, but see simpler method with `sample` in sample-from-file2"
  (:use [overtone.live]
        [overtone.inst.synth]
        [overtone-loops.loops]))

(defn filesample
  [path]
  (let [sample-buf (load-sample path)
        buf-id     (:id sample-buf)
        dur        (:duration sample-buf)
        channels   (:n-channels sample-buf)]
    (fn [ & args ]
      (cond
        (= 1 channels) (apply mono-sample-player buf-id dur args)
        (= 2 channels) (apply stereo-sample-player buf-id dur args)))))

(def boom (filesample "resources/samples/bd_boom.wav"))

(boom)

;; (stop)
