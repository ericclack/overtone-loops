(ns overtone-loops.examples.kick-kick-snare
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))  ;; (kick)
(def snare (freesound2 270156)) ;; (snare)
(def hat (freesound2 404890))   ;; (hat)
(def tom (freesound2 86331))    ;; (tom)
(def finger (freesound2 177495));; (finger)
(def clap (freesound2 24787))

;;                           1      2      3       4    //   5      6      7        8         
(defloop kicks   8 kick    [ 0.7    0.5    0.0     0         0.7    0.5     0.0     0.0    ])
(defloop toms    8 tom     [ 0.0    0.0    0.8     0.0       0.0    0.0     0.9     0.0    ])
(defloop hats    8 hat     [ 0.5    0.5    0.5    (0 0.5)    0.5    0.5    (0 0.5) (0 0.5) ])
(defloop fingers 2 finger []) ;; empty to start

;; alt patterns
(comment
  ;;                           1      2         3      4          //   5              6          7       8
  (defloop kicks   8 kick    [ 0.7    0.5       0.0    (0 0 0 0.5 0)  (0.7 0 0 0.5 0)      0.5   0.0     0.0    ])
  (defloop toms    8 tom     [ 0.0   (0.0 0.4)  0.8     0.0            0.0    (0.7 0.0 0.4 0.5)  0.9     0.2    ])
  (defloop fingers 2 finger  [ 0      0.5 ])

  ;; all toms
  (defloop toms    8 tom     [ 0.8    0.4       0.8    0.4             0.8            0.4        0.8    0.4 ])
  )

;; clear
(comment
  (defloop kicks 8 kicks [])
  )

;; ---------------------------------------------

(bpm 170)
  
(do
  (kicks (on-next-bar 4))
  (toms (on-next-bar 4))
  (hats (on-next-bar 4))
  (fingers (on-next-bar 4))
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  )

;;(stop)
