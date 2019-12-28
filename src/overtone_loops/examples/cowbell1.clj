(ns overtone-loops.examples.cowbell1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;;                        1 & 2 & 3 & 4 & 
(def hats
  (loop-player 1/2 hat   [_ 5 _ 5 _ 5 _ 5 ]))

(def kicks
  (loop-player 1/2 kick  [7 _ 2 _ 7 _ 2 _  7 _ 2 _ 7 _ 2 _  7 _ 2 _ 7 6 2 _  7 _ 2 _ 7 6 2 _ ]))

(def claps
  (loop-player 1/2 clap  [_ _ _ _ 3 _ _ _  _ _ _ _ 3 _ _ _  _ _ _ _ 4 _ _ _  _ _ _ _ _ 4 _ 6 ]))

;; Thirds                    1 and  2 and  3 and  4 and
(def bells
  (loop-player 1/3 cowbell  [4 _ _  4 _ _  4 _ _  4 6 4
                             4 _ _  _ _ 4  _ 6 _  _ 5 7
                             4 _ _  _ _ 4  _ 6 _  _ 5 7
                             4 _ _  _ _ 4  _ 6 _  _ 5 7 ]))
  
;; ---------------------------------------------

(bpm 110)
(beats-in-bar 4)
  
(at-bar 1
  (hats )
  (kicks )
  (claps )
  )

(at-bar 5
  (bells)
  )

;;(stop)
