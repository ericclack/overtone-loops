(ns overtone-loops.proto.schedule-tests-overtone2
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

(definst isnare [freq 200 dur 0.5 width 0.5]
  (let [freq-env (* freq (env-gen (perc 0 (* 0.99 dur))))
        env (env-gen (perc 0.01 dur) 1 1 0 1 FREE)
        sqr (* (env-gen (perc 0 0.01)) (pulse (* 2 freq) width))
        src (sin-osc freq-env)
        drum (+ sqr (* env src))]
    (compander drum drum 0.2 1 0.1 0.01 0.01)))
;;(asnare)

;; ---------------------------------------------

(bpm 300)

(defn kicks [beat]
  (apply-by (metro beat)
            (fn []
              (doall (map
                      (fn [b]
                        (at (metro (+ beat b)) (ikick)))
                      [0 1 3 4]))
              (kicks (+ beat 8)))))

(defn snares [beat]
  (apply-by (metro beat)
            (fn []
              (doall (map
                      (fn [b]
                        (at (metro (+ beat b)) (isnare)))
                      [2 5 7]))
              (snares (+ beat 8)))))  

(kicks (metro))
(snares (metro))


;;(stop)
