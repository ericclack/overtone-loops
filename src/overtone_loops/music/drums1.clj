(ns overtone-loops.music.drums1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;;                                     1 & 2 & 3 & 4 & 5 & 6 & 7 & 8 & 
(defloop ticks     1   cymbal-pedal   [4   3   4   3  ])
(defloop hats      1/2 cymbal-closed  [_ 5 _ 7 _ 7 _ 7])
(defloop crashes   1   cymbal-open    [_   _   3   _   _   _   _   _  ])

(defloop kicks     1/2 bass-hard      [6 _ 4 _ _ _ 4 _ 6 _ 4 _ _ _ 4 _])
(defloop snares    1/2 snare-hard     [_ _ _ _ 6 _ _ 3 _ _ _ 1 6 1 _ 3])

;; ---------------------------------------------

(bpm 130)
(beats-in-bar 4)
  
(at-bar 1
  (ticks)
  (hats)
  (kicks)
  )

(at-bar 3
  (crashes)
)

(at-bar 5
  (snares)
  )

(comment
  (silence (on-next-bar) ticks hats kicks crashes snares)
  (stop)
  )
