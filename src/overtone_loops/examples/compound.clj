(ns overtone-loops.examples.compound
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples])
  (:require [clojure.pprint :refer [pp pprint]]))

;; Model compound time 12/8 with bass playing every beat
;; and snares playing off-beats

;; Stop any currently playing music and clear any patterns
(set-up)

;; Define players with start patterns   1 . . 2 . . 3 . . 4 . . 
(def ticks  (loop-player 1 bass-soft   [6 _ _ 6 _ _ 6 _ _ 6 _ _ ]))
(def snares (loop-player 1 snare-soft  [3 _ 3 _ 3 _ 3 _ 3 _ 3 2 ]))

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

(at-bar 13
        (snares :first))

        
;;(stop)

(comment
  (cymbal-closed)
  )
