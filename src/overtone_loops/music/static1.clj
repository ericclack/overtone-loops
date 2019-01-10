(ns overtone-loops.music.alter1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def finger (freesound2 177495))
(def clap (freesound2 24787))

;; All half beats
(defloop hats    8 hat     [0.2  0.7   0.2   0.7   0   0.7   0.2   0.7 ])
(defloop fingers 8 finger  [1    0     0     0     1   0     0     0   ])
  
(defloop kicks   8 kick    [1    0     1     0     1   0     1     0   ])
(defloop claps   8 clap    [0    0.6   0     0     0   0.6   0.7   0.8 ])

;; ---------------------------------------------

(bpm 220) ;; half beats
  
(do
  (hats (on-next-bar 8))
  (fingers (on-next-bar 8 5))

  (kicks (on-next-bar 8 9))   
  (claps (on-next-bar 8 13) 4)   
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  )

;;(stop)
