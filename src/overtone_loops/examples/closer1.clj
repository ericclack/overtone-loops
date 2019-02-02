(ns overtone-loops.examples.closer1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def hat (freesound2 404890))
(def snare (freesound2 270156))
(def kick (freesound2 171104))


(def bell (freesound2 382806))

;;                              1 & 2 & 3 & 4 & 
(defloop hats   (4 1/2) hat    [- 5 - 5 - 5 - 5 ])

(defloop kicks  (16 1/2) kick  [7 - 2 - 7 - 2 -  7 - 2 - 7 6 2 -  7 5 2 - 7 - 2 -  7 5 2 - 7 6 2 - ])
(defloop sd     (16 1/2) snare [- - 7 - - - 7 -  - - 7 - - - 7 -  - - 7 - - - 7 -  - - 7 5 - 4 8 - ]) 

(defloop bells  (4 1/2) bell   [- 8 5 7 - 8 - 5 ])
  
;; ---------------------------------------------

(bpm 110)

(defn half-beat? [b]
  (and (ratio? b)
       (= (denominator b) 2)))

(defn close_beat [b]
  (if (half-beat? b)
    b
    (- b 1/3)))

(at-bar 1
        (hats)
        (kicks)
        (sd)
        )
  
(at-bar 3
        (bells close_beat)
        )

;;(stop)
