(ns overtone-loops.examples.compound
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples])
  (:require [clojure.pprint :refer [pp pprint]]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Define loop players with default patterns  1 . . 2 . . 3 . . 4 . . 
(def ticks  (loop-player 12    bass-soft     [6 _ _ 6 _ _ 6 _ _ 6 _ _ ]))
(def snares (loop-player 12    snare-hard    [3 _ 3 _ 3 _ 3 _ 3 _ 3 2 ]))

(def silence    [])

;; ---------------------------------------------

(bpm 300)
(beats-in-bar 12)

;; Calling a player starts it, passing a new pattern (list)
;; changes the pattern

;; Start playing each loop
(at-bar 1
        (ticks))

(at-bar 3
        (snares))

(at-bar 8
        (snares [3 1 3 1 3 1 3 _ 3 _ 3 1 ]))

(at-bar 9
        (snares [3 1 3 1 3 1 3 _ 3 1 3 1 ]))

(at-bar 10
        (snares [3 1 3 1 3 1 3 _ 3 _ 3 1 ]))

(at-bar 11
        (snares [3 _ _ _ _ _ _ _ _ _ _ 3 ]))

(at-bar 12
        (snares [3 _ _ _ _ _ _ _ _ _ _ _ ]))

        
;; at-bar often runs the commands immediately (on compile)
;; but schedules playback. Switch to apply-by

;;(stop)

(comment
  (cymbal-closed)
  )
