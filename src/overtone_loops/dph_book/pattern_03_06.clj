(ns overtone-loops.dph-book.pattern-03-05
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 270156))
(def kick (freesound2 171104))

(def crash (freesound2 439789))
(def clap (freesound2 24787))

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

(do
  ;; Play hh forever
  (closed-hhs (on-next-bar 4))

  ;; 4 bars standard: 1-4
  (sds        (on-next-bar 4) 4)
  (kicks04    (on-next-bar 4) 1) ;; 4 bar phrase

  ;; Now mix it up:
  ;; Bars 5-8
  (sds        (on-next-bar 4 5) 3) ;; 1 bar phrase for 3 bars
  (kicks03    (on-next-bar 4 5) 1) ;; 3 bar
  (sds1       (on-next-bar 4 8) 1)
  (kicks1     (on-next-bar 4 8) 1)

  ;; Bars 9-12
  (sds        (on-next-bar 4 9) 2) ;; 1 bar phrase for 2 bars
  (kicks02    (on-next-bar 4 9) 1) ;; 2 bar

  (sds3       (on-next-bar 4 11) 1)
  (kicks3     (on-next-bar 4 11) 1)  
  (sds4       (on-next-bar 4 12) 1)
  (kicks4     (on-next-bar 4 12) 1)

  ;; Bars 13-16
  (sds        (on-next-bar 4 13) 2) ;; 1 bar phrase for 2 bars
  (kicks02    (on-next-bar 4 13) 1) ;; 2 bar

  (sds2       (on-next-bar 4 15) 1)
  (kicks2     (on-next-bar 4 15) 1)  
  (sds1       (on-next-bar 4 16) 1)
  (kicks1     (on-next-bar 4 16) 1)
  
  ;; Back to usual: 17-20
  (sds        (on-next-bar 4 17) 4)
  (kicks04    (on-next-bar 4 17) 1) ;; 4 bar phrase
  )

;;(stop)
