(ns overtone-loops.music.alter1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(amp-scale 1/9)

;;                                1 & 2 & 3 & 4 &  5 & 6 & 7 & 8 &
(defloop hats    (8 1/2) hat           [- 5 - 5 - 5 - 5  - - - - 5 9 5 9 ])
(defloop crashes (8 1/2) cymbal-open   [- - - - 4                        ])
(defloop claps    4      clap          [-   6   -   8    -   6   -   8   ])
(defloop kicks   (4 1/2) bass-soft     [7 - - - 2 - - -  7 - - - 2 - - - ])

(defloop exkicks (8 1/2) bass-hard     [- - - - - - - -  - 4 - 4 - - - - ])

(defloop extra-snares 16
  2.5 (snare :amp 0.8)
  3 (snare :amp 0.5)
  3.5 (snare :amp 0.2)
  
  6.5 (snare :amp 0.8)
  7 (snare :amp 0.5)
  7.5 (snare :amp 0.2)
  
  12.6 (snare :amp 0.4)
  12.7 (snare :amp 0.5)
  12.8 (snare :amp 0.6)
  13 (snare :amp 0.8)  
  13.3 (snare :amp 0.4)
  13.5 (snare :amp 0.4)
  14 (snare :amp 0.7)
  )

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
        (exkicks 4))

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (exkicks (on-next-bar) 4)
  (extra-snares (on-next-bar) 8)
  )

;;(stop)
