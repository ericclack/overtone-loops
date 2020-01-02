(ns overtone-loops.music.pirates
  (:use [overtone.live]
        [overtone.inst.piano]
        [overtone-loops.loops]
        [overtone-loops.samples])
  (:require [clojure.pprint :refer [pp pprint]]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Function to play piano notes
(defn fpiano
  [anote]
  (piano :note (note anote)
         :vel 50
         :sustain 0.2
         :decay 0.1))
;; (fpiano :c4)
;; (stop)

;; Define loop players with default patterns
;;                        1   .   .   2   .   .   3   .   .   4   .   . 
(def ticks  (loop-player 1 bass-soft
                         [6   _   _   6   _   _   6   _   _   6   _   _  ]))
(def music  (loop-player 1 fpiano
                         [:d4 _   :d4 _   :d4 _   :d4 _   :d4 _   :d4 :c4]))

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
        
(comment
  (silence (metro) music ticks)
  (stop)
  )
