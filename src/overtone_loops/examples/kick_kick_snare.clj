(ns overtone-loops.examples.kick-kick-snare
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;;                          1 & 2 & 3 & 4 &  5 & 6 & 7 & 8 &         
(def hats
  (loop-player 1/2 hat     [_ 5 _ 5 _ 5 _ 5  5 _ _ 5 5 _ _ 5]))

(def kicks
  (loop-player 1/2 kick    [8 _ 8 _ _ _ _ _]))
(def snares
  (loop-player 1/2 snare   [_ _ _ _ 8 _ _ _  _ _ _ _ 8 _ _ _
                            _ _ _ _ 7 _ _ _  _ _ _ 3 _ 5 7 _]))



;; ---------------------------------------------

(bpm 140)
(beats-in-bar 4)

(at-bar 1
  (kicks )
  (snares )
  (hats )
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  )

;;(stop)
