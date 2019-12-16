(ns overtone-loops.music.rap2
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples])
  (:require [clojure.pprint :refer [pp pprint]]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Half beats                          1   &   2   &   3   &   4   &
(def ticks
  (loop-player [4 1/2] cymbal-closed  [7   5   6   5   7   5   _   3 ]))
(def hats
  (loop-player [4 1/2] cymbal-pedal   [_   _   _   _   _   _   6   _ ]))

;; Quarter beats                       1 e & a 2 e & a 3 e & a 4 e & a 
(def snares
  (loop-player [16 1/4] snare-soft    [_ _ _ _ 7 _ _ _ _ _ _ _ 9 _ _ _
                                       _ _ 5 _ 7 _ _ _ 7 _ _ _ 9 _ _ 5
                                       _ _ _ _ 7 _ _ 1 _ 1 _ _ 9 _ _ _
                                       _ _ 5 _ 7 _ _ _ 7 _ _ _ 9 1 _ 5
                                       ]))

(def kicks
  (loop-player [16 1/4] bass-elec     [6 _ _ 6 _ _ _ _ 6 _ _ _ _ _ _ _
                                       6 _ _ 6 _ _ _ _ 6 _ _ _ _ _ _ _
                                       6 _ _ 6 _ _ _ _ 6 _ 5 _ 4 6 _ _
                                       6 _ 1 6 _ 1 _ 1 6 _ 5 1 4 6 1 1 
                                       ]))

(defn rep [n vec]
  (into [] (apply concat (repeat n vec))))

;; ---------------------------------------------

(bpm 105)
(beats-in-bar 4)

(at-bar 1
        (ticks)
        (hats)
        (kicks)
        (snares)
  )

(comment
  ;; w off-beat
  (kicks (metro) (rep 4 [6 _ _ 6 _ _ _ _ 6 _ _ _ _ _ _ _]))
  (kicks (metro) :pop)
  ;; regular
  (kicks (metro) (rep 4 [6 _ 3 _ 5 _ _ _ 6 _ 3 _ 4 _ _ _]))
  ;; regular offbeat
  (kicks (metro) (rep 4 [_ _ 6 _ _ _ 5 _ _ _ 6 _ _ _ 4 _]))
  ;; back to original pattern
  (kicks (metro) :first)
  ;; tests
  (ticks (metro) [6 _ 6 _ 6 _ 6 _])
  (ticks (metro) [_ 6 _ 6 _ 6 _ 6])
  (ticks (metro) :pop)

  ;; snares
  (snares (metro) (rep 8 [_ 3 _ _ 6 _ _ 3]))
  (snares (metro) :pop)
  (snares (metro) :first)
  )

;;(stop)
