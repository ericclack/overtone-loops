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

;;                                    1 & 2 & 3 & 4 &
(def kicks (loop-player  1/2 fkick    [6 6 _ 6 6 _ _ _ ]))
(def snares (loop-player 1/2 fsnare   [_ _ 7 _ _ 6 _ 2 ]))

;; ---------------------------------------------

(bpm 150)
(beats-in-bar 4)

(kicks (metro))
(snares (metro))

;;(stop)
