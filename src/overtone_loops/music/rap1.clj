(ns overtone-loops.music.rap1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Stop any currently playing music and clear any patterns
(set-up)

;;                                           1 & 2 & 3 & 4 &
(def ticks (loop-player  1/2 cymbal-closed  [7 5 6 5 7 5 _ 3 ]))
(def hats  (loop-player  1/2 cymbal-pedal   [_ _ _ _ _ _ 6 _ ]))

(def kicks (loop-player  1/2 bass-hard      [6 6 _ _ 6 _ _ _ ]))
(def snares (loop-player 1/2 snare-hard     [_ _ 7 _ _ _ 9 _ ]))

(def extra-kicks  [6 6 _ _ 6 5 _ 6 ])
(def extra-snares [_ 2 7 7 _ _ 9 3 ])

;; TO DO...
(defn late-halves
  "Play half beats a bit late"
  [b]
  (if (half-beat? b) (+ b 1/3)
      b))

;; ---------------------------------------------

(bpm 140)
(beats-in-bar 4)

(at-bar 1
        (ticks)
        (hats ))

(at-bar 3
        (kicks)
        (snares))

(comment ; all play for only 2-3 phrases
  (kicks (metro) extra-kicks)
  (kicks (metro) [6 _ _ 3 6 _ _ 3 ])
  (kicks (metro) :first)

  (snares (metro) extra-snares)
  (snares (metro) :first)
  )

(comment
  (silence (metro) ticks hats kicks snares)
  (stop)
 )
