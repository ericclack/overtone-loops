(ns overtone-loops.proto.loop_fns
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples])
  (:require [clojure.pprint :refer [pp pprint]]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Define loop players with default patterns    1 & 2 & 3 & 4 &
(def ticks (loop-player  [4 1/2] cymbal-closed [7 5 6 5 7 5 _ 3 ]))
(def hats (loop-player   [4 1/2] cymbal-pedal  [_ _ _ _ _ _ 6 _ ]))

(def kicks (loop-player  [4 1/2] bass-hard     [6 6 _ _ 6 _ _ _ ]))
(def snares (loop-player [4 1/2] snare-hard    [_ _ 7 _ _ _ 9 _ ]))

(def alt-kicks  [_ _ _ _ _ 5 _ 6 ])
(def alt-snares [_ 2 _ 7 _ _ _ 3 ])
(def silence    [])

;; ---------------------------------------------

(bpm 105)
(beats-in-bar 4)

;; Calling a player starts it, passing a new pattern (list)
;; changes the pattern

;; Start playing each loop
(at-bar 1
        (ticks)
        (hats))

(at-bar 5
        (kicks))

(at-bar 7
        (snares))

(at-bar 9
        (kicks alt-kicks))

;;(hats)
;;(kicks)

;;(stop)

(comment
  alt-kicks
  (kicks (metro) alt-kicks)
  (snares (metro) alt-snares)
  (snares (metro) silence)
  )
