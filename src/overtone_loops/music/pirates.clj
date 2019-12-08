(ns overtone-loops.music.pirates
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples])
  (:require [clojure.pprint :refer [pp pprint]]))

;; Stop any currently playing music and clear any patterns
(set-up)

(defn note->hz [n] (midi->hz (note n)))

(definst tone [freq 440 amp 0.7 sustain 0.5 release 0.5]
  "Sine tone that lasts about half a second"
  (let [env (env-gen (lin :sustain sustain :release release) :action FREE)
        src (sin-osc freq)]
    (* amp env src)))
;; (tone (note->hz :c3))
;; (tone :amp 0.1)

(defn atone
  [anote]
  (tone :freq (note->hz anote)
        :amp 3/9 ; :amp (/ amp 9)
        :sustain 0.1
        :release 0.05))
;; (atone :c4 3)

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Define loop players with default patterns
;;                        1   .   .   2   .   .   3   .   .   4   .   . 
(def ticks  (loop-player 12 bass-soft
                         [6   _   _   6   _   _   6   _   _   6   _   _  ]))
(def music  (loop-player 12 atone
                         [:d4 _   :d4 _   :d4 _   :d4 _   :d4 _   :d4 :c4]))

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
        (music))

(at-bar 8
        (music [:d4 :c4 :d4 :c4 :d4 :c4 :d4 _ :d4 _ :d4 :c4 ]))

(at-bar 9
        (music [:d4 :c4 :d4 :c4 :d4 :c4 :d4 _ :d4 :c4 :d4 :c4 ]))

(at-bar 10
        (music [:d4 :c4 :d4 :c4 :d4 :c4 :f4 _ :e4 _ :d4 :c4 ]))

(at-bar 11
        (music [:d4 _ _ _ _ _ _ _ _ _ _ :d4 ]))

(at-bar 12
        (music [:d4 _ _ _ _ _ _ _ _ _ _ _ ]))
        
;;(stop)

(comment
  (cymbal-closed)
  )
