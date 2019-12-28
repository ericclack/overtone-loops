(ns overtone-loops.proto.simple
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Loop patterns
(defloop ticks   1  cymbal-pedal   [4   2   4   2  ])
(defloop kicks   1  bass-hard      [_   5   _   5  ])
(defloop snares  1  snare-hard     [_   _   5   _  ])
(defloop claps   1  clap           [5   _   _   _  ])

;; ---------------------------------------------

(bpm 130)
(beats-in-bar 4)

(at-bar 1
        (ticks)
        (claps))

(comment
    ;; Put live code here
  (claps (metro) :pop)
    ;;
    (stop)
    )
