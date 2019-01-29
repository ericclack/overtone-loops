(ns overtone-loops.music.sticks1
  (:use [overtone.live]
        [overtone.inst.synth]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 56430))
(def stick (freesound2 82280))
(def rim (freesound2 34831))

;;                             1 e & a 2 e & a 3 e & a 4 e & a 
(defloop sticks (4 1/4) stick [8 - - - 6 - - 6 - - 6 - - 6 - - ]) 
(defloop kicks  4       kick  [8       8       8       8       ])


(defloop bass-line 4
  0 (overpad (note :f2) :amp 0.3)
  )

;; (ctl vintage-bass :gate 0)

(defloop extra-sticks 1
  0 (rim :amp 0.5)
  0.7 (rim)
  )

;; ---------------------------------------------

(bpm 85)
(beats-in-bar 4)

(at-bar 1
        (sticks )
        (kicks )
        ;;(bass-line )
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (extra-sticks (on-next-bar) 8)
  )

;;(stop)
