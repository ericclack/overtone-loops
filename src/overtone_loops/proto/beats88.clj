(ns overtone-loops.proto.beats88
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Loop patterns
(defloop kicks   1/2 bass-soft     [6 _ 5 _ 5 _ _ _  _ _ _ _ _ _ _ _ ])

(defloop ticks   1/2 cymbal-closed [5 1 4 1 5 2 4 1  6 1 4 2 5 3 6 1 ])

(defloop snares  1/2 snare-hard    [_ _ _ _ _ _ 5 _  _ _ _ _ _ _ 4 _ ])

(defloop bells   1/2 ride          [4 _ _ _ 3 _ _ 6  _ _ _ _ 5 _ _ _ ])

;; ---------------------------------------------

(bpm 240)
(beats-in-bar 8)

(at-bar 1
        (kicks))

(at-bar 3
        (ticks))

(at-bar 5
        (snares))

(at-bar 7
        (bells))

(comment
  ;; Put live code here

  ;; Kicks
  (kicks (metro)  [6 _ 5 _ 5 _ _ _  _ 4 6 2 _ _ _ 3 ])
  (kicks (metro)  [6 _ 5 _ 5 _ 3 _  6 1 7 1 4 _ 6 3 ])
  (kicks (metro) :first)

  ;; Snares
  (snares (metro) [_ _ _ _ _ _ 6 _  _ 1 _ _ 2 _ 5 _ ])
  (snares (metro) :first)

  ;; Rides
  (bells (metro)  [4 _ _ _ 3 _ _ _  6 _ _ _ 3 _ _ _ ])
  (bells (metro) :first)

  ;; 
  ;;
  (silence (metro) kicks snares bells ticks)
  (stop)
  )
