(ns overtone-loops.music.static1
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Aiming for something like Eat Static - Shadow Locked

(set-up)

;; Instruments ---------------------------------------------------------

(defn note->hz [n] (midi->hz (note n)))

(definst tone [freq 440 amp 0.7 sustain 0.5 release 0.5]
  "Sine tone that lasts about half a second"
  (let [env (env-gen (lin :sustain sustain :release release) :action FREE)
        src (sin-osc freq)]
    (* amp env src)))
;; (tone (note->hz :c3))
;; (tone :amp 0.1)

(defn atone [[anote amp]]
  (tone :freq (note->hz anote)
        :amp (/ amp 9)
        :sustain 0.1
        :release 0.05))

;; Patterns ------------------------------------------------------------

;; We want to use amps between 0 and 9 in our lists
(amp-scale 1/9)

;;                                 1 & 2 & 3 & 4 &   1 & 2 & 3 & 4 &   1 & 2 & 3 & 4 &   1 & 2 & 3 & 4 &   
(def hats
  (loop-player [4 1/2] hat      [2 7 2 7 _ 7 2 7 ]))

(def fingers
  (loop-player 4      finger    [9   _   9   _   ]))

(def kicks
  (loop-player 4      kick      [6   6   6   6   ]))

(def claps
  (loop-player [8 1/2] clap     [_ 6 _ _ _ 6 _ _   _ 6 _ _ _ 3 7 3 ]))

(def bass1
  (loop-player [4 1/2] atone   [[:f2 4] [:f2 2] [:f2 4] [:d2 2]
                                [:f2 4] [:d2 2] [:f2 4] [:g2 2]]))

(def bass2
  (loop-player [4 1/2] atone   [[:c3 4]  [:f3 2]  _       [:c3 2]
                                [:ab3 4] [:ab3 2] [:c3 4] [:f3 2]]))

;; ---------------------------------------------

(bpm 110) ;; half beats
(beats-in-bar 4)

(at-bar 1
        (hats)) ;; forever

(at-bar 5
        (bass1))

(at-bar 7
        (fingers)) ;; forever

(at-bar 9
        (bass1 [])
        (kicks)) ;; forever

(at-bar 13
        (claps))

(at-bar 15        
        (bass2)
        (claps []))

(comment ; all play for only a few phrases
  ;; Play these with Ctrl-X Ctrl-E
  (bass1 (on-next-bar) 6)
  (claps (on-next-bar) 4)
  (bass2 (on-next-bar) 4)

  ;;
  (bass1 (metro))
  )

;;(stop)
