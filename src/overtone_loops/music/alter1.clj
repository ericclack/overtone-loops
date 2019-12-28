(ns overtone-loops.music.alter1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;;                                1 & 2 & 3 & 4 &  5 & 6 & 7 & 8 &
(def hats
  (loop-player 1/2 cymbal-closed [_ 5 _ 5 _ 5 _ 5  _ _ _ _ 5 9 5 9 ]))
(def crashes
  (loop-player 1/2 cymbal-open   [_ _ _ _ 4 _ _ _  _ _ _ _ _ _ _ _ ]))
(def claps
  (loop-player 1   clap          [_   6   _   8    _   6   _   8   ]))
(def kicks
  (loop-player 1/2 bass-soft     [7 _ _ _ 2 _ _ _  7 _ _ _ 2 _ _ _ ]))

(def exkicks [7 _ _ _ 2 _ _ _  7 4 _ 4 2 _ _ _ ])

(def extra-snares      ;;  0 1 2 3 4 5 6 7 8 9  0 1 2 3 4 5 6 7 8 9  0 1 2 3 4 5 6 7 8 9  0 1 2 3 4 5 6 7 8 9  
  (loop-player 1/10 snare [_ _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ _ _  _ _ _ _ _ 8 _ _ _ _  5 _ _ _ _ 2 _ _ _ _ ;; 0-3
                           _ _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ _ _  _ _ _ _ _ 8 _ _ _ _  5 _ _ _ _ 2 _ _ _ _ ;; 4-7
                           _ _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ _ _ ;; 8-11
                           _ _ _ _ _ _ 4 5 6 _  8 _ _ 4 4 _ _ _ _ _  7 _ _ _ _ _ _ _ _ _  _ _ _ _ _ _ _ _ _ _ ])) ;; 12-15
  
;; ---------------------------------------------

(bpm 130)
(beats-in-bar 4)

(at-bar 1
        (hats )
        (claps )
        (kicks )
        (crashes )
  )

(at-bar 3
        (kicks exkicks))

(at-bar 7
        (kicks :pop))

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (kicks (on-next-bar) exkicks)
  (extra-snares (on-next-bar))
  )

;;(stop)
