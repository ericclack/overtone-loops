(ns overtone-loops.proto.schedule-tests
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

;; Stop any currently playing music and clear any patterns
(set-up)

;; Instruments

(definst ikick [freq 100 dur 0.5 width 0.5]
  (let [freq-env (* freq (env-gen (perc 0 (* 0.99 dur))))
        env (env-gen (perc 0.01 dur) 1 1 0 1 FREE)
        sqr (* (env-gen (perc 0 0.01)) (pulse (* 2 freq) width))
        src (sin-osc freq-env)
        drum (+ sqr (* env src))]
    (compander drum drum 0.2 1 0.1 0.01 0.01)))
;;(ikick)

(defn fkick [amp]
  (ikick))
;;(fkick 4/9)

(definst isnare [freq 200 dur 0.5 width 0.5]
  (let [freq-env (* freq (env-gen (perc 0 (* 0.99 dur))))
        env (env-gen (perc 0.01 dur) 1 1 0 1 FREE)
        sqr (* (env-gen (perc 0 0.01)) (pulse (* 2 freq) width))
        src (sin-osc freq-env)
        drum (+ sqr (* env src))]
    (compander drum drum 0.2 1 0.1 0.01 0.01)))
;;(asnare)

(defn fsnare [amp]
  (isnare))

(definst ihat [amp 0.8 t 0.04]
  (let [env (env-gen (perc 0.001 t) 1 1 0 1 FREE)
        noise (white-noise)
        sqr (* (env-gen (perc 0.01 0.04)) (pulse 880 0.2))
        filt (bpf (+ sqr noise) 9000 0.5)]
    (* amp env filt)))
;;(ahat)

(defn fhat [amp]
  (ihat amp))

(definst ihat2 [amp 0.8 t 0.08]
  (let [env (env-gen (perc 0.001 t) 1 1 0 1 FREE)
        noise (white-noise)
        sqr (* (env-gen (perc 0.01 0.04)) (pulse 880 0.2))
        filt (bpf (+ sqr noise) 9000 0.5)]
    (* amp env filt)))
;;(ahat2)

(defn fhat2 [amp]
  (ihat2 amp))

;;                                    1 & 2 & 3 & 4 &
(def ticks (loop-player  1/2 fhat     [7 5 6 5 7 5 6 3 ]))
(def kicks (loop-player  1/2 fkick    [6 6 _ _ 6 _ _ _ ]))
(def snares (loop-player 1/2 fsnare   [_ _ 7 _ _ _ 9 _ ]))

;; ---------------------------------------------

(bpm 150)
(beats-in-bar 4)

(at-bar 1
        (ticks))

(at-bar 3
        (kicks)
        (snares))

(comment ; all play for only 2-3 phrases
  (kicks (metro) [6 _ _ 3 6 _ _ 3 ])
  (kicks (metro) :first)

  (snares (metro) [_ _ 5 _ _ 5 _ _ ])
  (snares (metro) :first)
  )

;;(stop)
