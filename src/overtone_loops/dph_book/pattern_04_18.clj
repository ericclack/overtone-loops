(ns overtone-loops.dph-book.pattern-04-18
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def open-hh (freesound2 404893))
(def snare (freesound2 404859))
(def kick (freesound2 171104))

(def ride (freesound2 162311)) ;; (ride)
(def ride-bell (freesound2 171482)) ;; (ride-bell)

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;; 12 / 8 beats                        1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .  
(defloop ridebells (16 1/6) open-hh   [7 - - - - - 7 - - - - - 7 - - - - - - - 7 - - -   7 - - - - - 6 - - - - - 7 - - - - - - - 4 - 6 -   - - - - - - - - - - - - - - 3 - 5 - 7 - - - - -   7 - - - 5 - - - - - 5 - - - - - - 7 - - - - - - ])
(defloop rides     (16 1/6) closed-hh [- - 3 - 5 - - - 4 - 5 - - - 1 4 5 - - 5 - - 4 6   - - 4 - 5 - - - 4 - 6 - - 2 3 - 5 - 7 - - - - -   8 - 3 - 5 - 8 - 4 - 5 - 8 - - - - - - - - - - -   - - 4 - - - 8 - 4 - - - 8 5 4 - 5 - 8 - 4 - 5 - ])

(defloop sds       (16 1/6) snare     [- - - - - - 8 - - - - - - - - - - - 8 - - - 6 -   - - - - - - 8 - - - - - - - - 3 - - 8 - - - - -   - - - - - - 8 - - 3 - - - - - - - - 8 - - - 6 -   - - - - - - 8 - - - - - - - - 3 - - 8 - - - - - ])
(defloop kicks     (16 1/6) kick      [7 - - - 7 - - - - - 5 - 8 - - - - - - - - - 2 3   8 - - - 4 - - - - - 7 - 8 - - - - - - - - - 6 -   7 - - 5 7 - - - - - 5 - 8 - - - - - - - - - - -   8 - - - - - - - - 5 7 - - - - - 7 8 - - - - 6 - ])
;; 12 / 8 beats                        1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .   1 . t . t . 2 . t . t . 3 . t . t . 4 . t . t .

(bpm 98 )
(beats-in-bar 4)

(at-bar 1
        (ridebells)
        (rides)
        (sds)
        (kicks)
        )

;;(stop)
