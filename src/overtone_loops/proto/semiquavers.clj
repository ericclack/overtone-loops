(ns overtone-loops.proto.semiquavers
  (:use [overtone.live]
        [overtone.inst.piano]        
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)

;; Patterns ------------------------------------------------------------
;; Instruments
;; Function to play piano notes
(defn fpiano
  [anote]
  (piano :note (note anote)
         :vel 70
         :sustain 0.2
         :decay 0.1))

;; Patterns ------------------------------------------------------------
;;                           1       2       3       4 
(defloop pat1    1  finger  [6       6       6       6      ])
(defloop pat2   1/4 finger  [7 _ 4 _ 7 _ 4 _ 7 _ 4 _ 7 _ 4 _])

(defloop melody 1/4 fpiano  [:f4  _ _ _
                             :bb4 _ _ _
                             :a4  _ :c4 _
                             :bb4 _ _ _ ])

;; (cymbal-closed)

;; ---------------------------------------------------------------------

(bpm 130) 
(beats-in-bar 4)

(at-bar 1
        (pat1)
        (melody)
        )

(at-bar 5
        (silence pat1)
        (pat2)
        (melody [:f4  _ _ _
                 :bb4 _ _ _
                 :a4  _ _ _
                 :bb4 _ _ _ ]))

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (silence (metro) pat1)
  (pat2 (on-next-bar))

  (pat2 (metro) [3 _ 7 _ 3 _ 7 _ 3 _ 7 _ 3 _ 7 _])
  (pat2 (metro) [_ _ 7 _ _ _ 7 2 4 _ 7 _ _ _ 7 _])
  (pat2 (metro) [_ 7 _ _ _ 7 _ _ _ 7 _ _ _ 7 _ _])
  (pat2 (metro) :first)
   
  (melody (metro) [:f4  _   :d4 :d#4
                   :f4  _   _    _
                   :f4  :g4 :bb4 :g4
                   :c4  _   _    _ ])
  
  (melody (metro) :pop)

  )

;;(stop)
