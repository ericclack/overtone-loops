(ns overtone-loops.proto.mar19-2019
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Patterns ------------------------------------------------------------

;;                                      1         2         3         4 
(defloop kicks  (4 1/5) bass-elec      [7 - - - 7 1 - - - - 7 - - - - 7 - - - - ])

;;                                      1 e & a 2 e & a 3 e & a 4 e & a
(defloop ticks  (4 1/2) cymbal-closed  [1   5   1   4   2   5   1   4   ])
(defloop clicks  4      finger         [8       -       8       -       ])
(defloop rides1 (4 1/2) ride           [7   7   6   7   8   7   8   6   ]) 

(defloop hats1   (4 1/4) cymbal-closed [- - 5 - - - 5 - - - 6 - - - 3 - ])
(defloop pedals1 (4 1/4) cymbal-pedal  [- - - - - - - - 3 - - - 2 - - - ])

(defloop hats2   (4 1/4) cymbal-closed [1 - 5 - 2 3 5 - 8 4 - 1 3 - 2 - ])
(defloop pedals2 (4 1/4) cymbal-pedal  [- 3 - 2 - - - - - - 2 - - 5 - 4 ])


;; ---------------------------------------------------------------------

(bpm 110) 
(beats-in-bar 4)

(defn shuffle [beat]
  (cond
    (half-beat? beat) (+ beat 1/16)
    (quarter-beat? beat) (+ beat 1/20)
    :else beat))

(at-bar 1
        (ticks 4 shuffle)
        (kicks 20) 
        ) 

(at-bar 5
        (hats1 12 shuffle)
        (pedals1 12 shuffle)
        )

(at-bar 13
        (clicks 8)
        )

(at-bar 17
        (hats2 shuffle)
        (pedals2 shuffle)
        )

(at-bar 25
        (kicks 20) 
)        

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (ticks (on-next-bar) shuffle)
  (hats (on-next-bar) shuffle)
  (rides1 (on-next-bar) 4 shuffle)

  ;; To stop any loop, redefine it as empty
  (emptyloop clicks 4)
  (emptyloop hats 4)
  (emptyloop pedals 4)
  )

;;(stop)
