(ns overtone-loops.proto.mar19-2019b
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Patterns ------------------------------------------------------------

;;                                      1         2         3         4
(defloop ticks  (4 1/2) cymbal-closed  [1   5     1   4     2   5     1   4     ])
(defloop kicks  (4 1/5) bass-elec      [7 - - - 7 1 - - - - 7 - - - - 7 - - - - ])

;; ---------------------------------------------------------------------

(bpm 110) 
(beats-in-bar 4)

(at-bar 1
        (ticks)
        (kicks) 
        ) 

;;(stop)
