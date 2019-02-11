(ns overtone-loops.dph-book.pattern-04-21a
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; Quarter beats                            1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a 
;;                                          |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
(defloop closed-hhs (4 1/4)  cymbal-closed [7 - 5 - 7 - 4 - 8 - 5 - 8 - 6 - ])
(defloop ride-bells (16 1/4) ride-bell     [- - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - -  5 - - - - - - - - - - - - 3 6 4  - - - - - - - - - 3 - 4 - 6 - 8 ])
(defloop sds        (16 1/4) snare-soft    [- 2 - - 7 1 - - - 5 - - 7 1 - 1  - 1 - - 7 1 - - - - - - 7 - - 5  - 5 - - 7 1 6 1 - - - - 7 1 - -  - - - - 7 1 - 1 - 5 - - 7 1 - - ])
(defloop kicks      (16 1/4) bass-soft     [6 - - 6 - - - 6 - - 7 - - - - -  6 - - - - - - 5 6 - 7 - - - 7 -  7 - 6 7 - - - 7 - - - - 3 7 - -  - - 7 - 3 7 - - - 7 - 8 - 6 - 5 ])
;;                                          |       |       |       |        |       |       |       |        |       |       |       |        |       |       |       |
;; Quarter beats                            1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a  1 e & a 2 e & a 3 e & a 4 e & a

(bpm 116)
(beats-in-bar 4)

(at-bar 1
  (closed-hhs)
  (ride-bells)
  (sds)
  (kicks)
  )

;;(stop)
