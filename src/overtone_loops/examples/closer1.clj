(ns overtone-loops.examples.closer1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;;                              1 & 2 & 3 & 4 & 
(def hats
  (loop-player 1/2 hat        [_ 5 _ 5 _ 5 _ 5 ]))

(def kicks
  (loop-player 1/2 kick       [7 _ _ _ 7 _ _ _  7 _ _ _ 7 6 5 _  7 5 2 _ 7 _ _ _  7 5 2 _ 7 6 2 _ ]))
(def sd
  (loop-player 1/2 snare      [_ _ 7 _ _ _ 7 _  _ _ 7 _ _ _ _ _  _ _ 7 _ _ _ 7 _  _ _ 7 5 _ 4 8 _ ]))

(def bells
  (loop-player 1/2 ride-bell  [_ 8 _ 7 _ 8 _ 6  _ 8 3 7 _ 8 _ 6  _ 8 5 7 _ 8 6 _  _ 8 _ 7 _ 8 5 6 ]))
  
;; ---------------------------------------------

(bpm 110)

(defn close_beat [b]
  (if (half-beat? b)
    b
    (- b 1/3)))

(at-bar 1
        (hats)
        (kicks)
        (sd)
        )
  
(at-bar 3
        (bells) ;; close_beat)
        )

;;(stop)
