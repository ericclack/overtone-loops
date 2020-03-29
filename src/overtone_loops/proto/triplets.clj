(ns overtone-loops.proto.triplets
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;; Patterns ------------------------------------------------------------
;;                         1     2     3     4 
(defloop pat1 1   finger  [6 6 6])
(defloop pat2 1/3 finger  [7 _ _ 7 _ _ 7 6 8 7 _ _ ])

;; (cymbal-closed)

;; ---------------------------------------------------------------------

(bpm 110) 
(beats-in-bar 4)

(at-bar 1
        (pat2)
)

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  )

;;(stop)
