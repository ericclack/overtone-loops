(ns overtone-loops.proto.mar19-2019
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Patterns ------------------------------------------------------------

;;                                      1 e & a 2 e & a 3 e & a 4 e & a
(defloop hats   (4 1/4) cymbal-closed  [1 - 5 - 2 3 5 - 8 4 - 1 3 - 2 - ])
(defloop pedals (4 1/4) cymbal-pedal   [- 3 - 2 - - - - - - 2 - - 7 - 4 ])
(defloop kicks  (4 1/4) bass-elec      [7 - - - 7 - - 4 2 - - - 7 - - - ])

(defloop clicks  4      finger         [8       -       8       -       ])
(defloop rides1  4      ride           [4       5       -       3       ]) 
(defloop rides2  4      ride-bell      [-       -       5       3       ]) 

;; ---------------------------------------------

(bpm 110) 
(beats-in-bar 4)

(at-bar 1
        ;; forever
        (hats)
        (pedals)
        (kicks) 
        ) 

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (clicks (on-next-bar) 4)
  
  (rides1 (on-next-bar) 4)
  (rides2 (on-next-bar) 4)
  )

;;(stop)
