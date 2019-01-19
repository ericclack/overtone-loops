(ns overtone-loops.dph-book.pattern-03-06
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 270156))
(def kick (freesound2 171104))

(def crash (freesound2 439789))
(def clap (freesound2 24787))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                   BAR1               BAR2               BAR3               BAR4                        

;;                                  1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop closed-hhs
  (4 1/2) closed-hh                [7 7 7 7 7 7 7 7 ])

(defloop sds      (4 1/2) snare    [- - 8 - - - 8 - ])

(defloop kicks02  (8  1/2) kick    [8 - - - 8 - - -    8 - - - 8 8 - -])
(defloop kicks03  (12 1/2) kick    [8 - - - 8 - - -    8 - - - 8 8 - -    8 8 - - - 8 - -])
(defloop kicks04  (16 1/2) kick    [8 - - - 8 - - -    8 - - - 8 8 - -    8 8 - - - 8 - -    8 8 - 8 - 8 - 8])

;; Variations
;;                                  1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop sds1     (4 1/2) snare    [- - 8 - - 8 - 8])    
(defloop kicks1   (4 1/2) kick     [8 - - 8 8 - - -])

(defloop sds2     (4 1/2) snare    [- - 8 - 8 - 8 -])
(defloop kicks2   (4 1/2) kick     [8 - - 8 - 8 - -])

(defloop sds3     (4 1/2) snare    [- 8 - - - - 8 -])
(defloop kicks3   (4 1/2) kick     [8 - - 8 8 - - 8])

(defloop sds4     (4 1/2) snare    [- 8 - - 8 - 8 -]) 
(defloop kicks4   (4 1/2) kick     [8 - 8 8 - 8 - -])

(bpm 160)
(beats-in-bar 4)

;; We use at-bar to schedule the loops

(at-bar 1
        ;; same HH pattern all the way through
        (closed-hhs 20) 

        ;; 4 bars standard: 1-4
        (sds     4)
        (kicks04 1) ;; 4 bar phrase
        )

;; Now mix it up:
;; Bars 5-8

(at-bar 5
        (sds     3) ;; 1 bar phrase for 3 bars
        (kicks03 1) ;; 3 bar
        )

(at-bar 8
        (sds1    1)
        (kicks1  1)
        )

(at-bar 9
        (sds     2) ;; 1 bar phrase for 2 bars
        (kicks02 1) ;; 2 bar
        )

(at-bar 11
        (sds3    1)
        (kicks3  1)
        )

(at-bar 12
        (sds4    1)
        (kicks4  1)
        )

(at-bar 13
  ;; Bars 13-16
  (sds     2) ;; 1 bar phrase for 2 bars
  (kicks02 1) ;; 2 bar
  )

(at-bar 15
        (sds2    1)
        (kicks2  1)  
  )

(at-bar 16
        (sds1    1)
        (kicks1  1)
        )

;; Back to usual 17-20
(at-bar 17
        (sds     4)
        (kicks04 1) ;; 4 bar phrase
        )

;;(stop)
