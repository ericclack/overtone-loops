(ns overtone-loops.music.static1
  (:use [overtone.live]
        [overtone-loops.loops]))

;; Aiming for something like Eat Static - Shadow Locked

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 270156))
(def hat (freesound2 404890))
(def finger (freesound2 177495))
(def clap (freesound2 24787))

;; Instruments ---------------------------------------------------------

(defn note->hz [n] (midi->hz (note n)))

(definst tone [freq 440 amp 0.7 sustain 0.5 release 0.5]
  "Sine tone that lasts about half a second"
  (let [env (env-gen (lin :sustain sustain :release release) :action FREE)
        src (sin-osc freq)]
    (* amp env src)))
;; (tone (note->hz :c3))
;; (tone :amp 0.1)

(defn tone-low [& {:keys [amp] :or {amp 0.7}}]
  (tone :freq (note->hz :f2)
        :amp amp
        :sustain 0.1
        :release 0.05)
  )

;; (tone-c3 :amp 0.3)
;; (tone-c3 :amp 0.1)

(defn tone-mid [& {:keys [amp] :or {amp 0.7}}]
  (tone :freq (note->hz (rand-nth [:c3 :ab3 :f3]))
        :amp amp
        :sustain 0.1
        :release 0.05)
  )

;; Patterns ------------------------------------------------------------
;;                                 1         2         3         4
(defloop hats    (4 1/2) hat      [0.2 0.7   0.2 0.7   0   0.7   0.2 0.7 ])
(defloop bass1   (4 1/2) tone-low [0.4 0.2   0.4 0.2   0.4 0.2   0.4 0.2 ])
(defloop fingers 4       finger   [1         0         1         0       ])

(defloop kicks   4       kick     [1         1         1         1       ])
(defloop claps   (4 1/2) clap     [0   0.6   0   0     0   0.3   0.7 0.3 ])
(defloop bass2   (4 1/2) tone-mid [0.4 0.2   0.0 0.2   0.4 0.2   0.4 0.2 ])

;; ---------------------------------------------

(bpm 110) ;; half beats
  
(do
  (hats (on-next-bar 4))
  (bass1 (on-next-bar 4 5) 6)
  (fingers (on-next-bar 4 7))

  (kicks (on-next-bar 4 11))   
  (claps (on-next-bar 4 15) 4)
  (bass2 (on-next-bar 4 15) 4)
  )

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (bass1 (on-next-bar 4) 6)
  (claps (on-next-bar 4) 4)
  (bass2 (on-next-bar 4) 4)
  )

;;(stop)
