(ns overtone-loops.proto.loop_fns
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples])
  (:require [clojure.pprint :refer [pp pprint]]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Define loop players with start pattern   1 & 2 & 3 & 4 &
(def ticks  (loop-player 1/2 cymbal-closed [7 5 6 5 7 5 _ 3 ]))
(def hats   (loop-player 1/2 cymbal-pedal  [_ _ _ _ _ _ 6 _ ]))

(def kicks  (loop-player 1/2 bass-hard     [6 6 _ _ 6 _ _ _ ]))
(def snares (loop-player 1/2 snare-hard    [_ _ 7 _ _ _ 9 _ ]))

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

(at-bar 3
        (kicks))

(at-bar 5
        (snares))

(at-bar 7
        ;; switch to a new pattern
        (kicks alt-kicks))

(at-bar 9
        ;; switch back to original pattern
        (kicks :pop))

;;(stop)

(comment
  ;; Run these in Emacs with Ctrl-X Ctrl-E

  (kicks (metro) alt-kicks)
  (kicks (metro) [6 6])
  (kicks (on-next-bar) :first)

  (snares (metro) alt-snares)
  (snares (metro) silence)
  )
