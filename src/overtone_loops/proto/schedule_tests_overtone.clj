(ns overtone-loops.proto.schedule-tests-overtone
  "Tests for instrument clashes, something I've seen fairly
  frequently: where one instrument takes the wrong rhythm.

  This code uses no Overtone Loops functionality. "
  (:use [overtone.live]))

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
              ;; This seems to work with no problems
              (at (metro (+ beat 0)) (ikick))
              (at (metro (+ beat 1)) (ikick))
              (at (metro (+ beat 3)) (ikick))
              (at (metro (+ beat 4)) (ikick))
              (kicks (+ beat 8)))))

(defn snares [beat]
  (apply-by (metro beat)
            (fn []
              (at (metro (+ beat 2)) (isnare))
              (at (metro (+ beat 5)) (isnare))
              (at (metro (+ beat 7)) (isnare))
              (snares (+ beat 8)))))  

(kicks (metro))
(snares (metro))


;;(stop)
