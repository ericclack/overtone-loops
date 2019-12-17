(ns overtone-loops.music.drums1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                                     1 & 2 & 3 & 4 & 5 & 6 & 7 & 8 & 
(defloop ticks     1   cymbal-pedal   [4   3   4   3  ])
(defloop hats1     1/2 cymbal-closed  [_ 5 _ 7 _ 7 _ 7])
(defloop crashes1  1   cymbal-open    [_   _   4   _   _   _   _   _])

(defloop kicks1    1/2 bass-hard      [6 _ 4 _ _ _ 4 _ 6 _ 4 _ _ _ 4 _])
(defloop snares1   1/2 snare-hard     [_ _ _ _ 6 _ _ 3 _ _ _ 1 6 1 _ 3])

;; ---------------------------------------------

(bpm 130)
(beats-in-bar 4)
  
(at-bar 1
  (ticks)
  (hats1)
  (kicks1)
  )

(at-bar 1
  (crashes1)
)

(at-bar 5
  (snares1)
  )

(comment
  )

;;(stop)
