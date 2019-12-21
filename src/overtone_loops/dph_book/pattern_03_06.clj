(ns overtone-loops.dph-book.pattern-03-06
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Define some samples from Freesound.org
(def closed-hh (freesound2 404890))
(def snare (freesound2 270156))
(def kick (freesound2 171104))

(def crash (freesound2 439789))
(def clap (freesound2 24787))

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                   BAR1               BAR2               BAR3               BAR4                        

;;                             1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(defloop closed-hhs
  1/2 closed-hh               [7 5 7 4 6 3 8 4 ])

(defloop sds      1/2 snare   [_ _ 8 _ _ _ 8 _ ])
(defloop kicks    1/2 kick    [8 _ _ _ 8 _ _ _    8 _ _ _ 8 8 _ _    8 8 _ _ _ 8 _ _    8 8 _ 8 _ 8 _ 8])

;; Variations
;;             1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & // 1 & 2 & 3 & 4 & 
(def kicks02  [8 _ _ _ 8 _ _ _    8 _ _ _ 8 8 _ _])
(def kicks03  [8 _ _ _ 8 _ _ _    8 _ _ _ 8 8 _ _    8 8 _ _ _ 8 _ _])

(def sds1     [_ _ 8 _ _ 8 _ 8])    
(def kicks1   [8 _ _ 8 8 _ _ _])

(def sds2     [_ _ 8 _ 8 _ 8 _])
(def kicks2   [8 _ _ 8 _ 8 _ _])

(def sds3     [_ 8 _ _ _ _ 8 _])
(def kicks3   [8 _ _ 8 8 _ _ 8])

(def sds4     [_ 8 _ _ 8 _ 8 _]) 
(def kicks4   [8 _ 8 8 _ 8 _ _])

(bpm 160)
(beats-in-bar 4)

;; We use at-bar to schedule the loops

(at-bar 1
        ;; same HH pattern all the way through
        (closed-hhs) 

        (sds)
        (kicks) 
        )

;; Now mix it up:
;; Bars 5-8

(at-bar 5
        (kicks kicks03) ;; 3 bar
        )

(at-bar 8
        (sds sds1)
        (kicks kicks1)
        )

(at-bar 9
        (kicks kicks02) ;; 2 bar
        )

(at-bar 11
        (sds sds3)
        (kicks kicks3)
        )

(at-bar 12
        (sds sds4)
        (kicks kicks4)
        )

(at-bar 13
  ;; Bars 13-16
  (sds :first)
  (kicks kicks02)
  )

(at-bar 15
        (sds sds2)
        (kicks kicks2)  
  )

(at-bar 16
        (sds sds1)
        (kicks kicks1)
        )

;; Back to usual 17-20
(at-bar 17
        (sds :first)
        (kicks :first) 
        )

(at-bar 21
        (sds [])
        (kicks [])
        )

(at-bar 22
        (closed-hhs []))

;;(stop)
