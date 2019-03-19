(ns overtone-loops.dph-book.pattern-04-13b
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                     BAR1               BAR2               BAR3               BAR4                        
;;                     1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop sds
  (16 1/2) snare-hard [- - 5 - - - 5 -    - - 5 - 2 4 - 6    - - 5 - - - 5 -    - - 5 - - - 5 -  ])
(defloop kicks
  (16 1/2) bass-hard  [8 - - 8 - - - 5    - 8 - 8 - - - -    8 - - 8 8 - - 8    8 3 - 8 - - - 8  ])

;;                     1 e & a 2 e & a 3 e & a 4 e & a  
(defloop ride-bells
  (4 1/4) ride-bell   [- - 5 - - - 4 - - - 2 - - - 5 - ])

(defloop rides
  (4 1/4) ride        [4 5 - - 4 5 - - - 4 - 3 4 3 - 3 ])


;;                         1 e & a 2 e & a 3 e & a 4 e & a  
(defloop fill1
  (4 1/4) tom-mid-hard    [- - - - - - - - 4 - 5 - - 5 - 8])
(defloop fill2
  (4 1/4) tom-lo-hard     [- - - - - - - - - 1 - 3 - - 3 -])

  
;; ---------------------------------------------

(bpm 105)
(beats-in-bar 4)

(defn swing [b]
  (if (quarter-beat? b) (+ b 1/16)
      b))
  
(at-bar 1
        (ride-bells swing)
        (rides swing)
        (sds)
        (kicks)
  )

(comment
  (do
    (fill1 (on-next-bar) 1)
    (fill2 (on-next-bar) 1)
    )
  )

;;(stop)
