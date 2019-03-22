(ns overtone-loops.proto.scratch1
  (:use [overtone.live]
        [overtone.inst.synth]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(defn note->hz [n] (midi->hz (note n)))

(supersaw (note :a7))
(ctl supersaw :amp 0.5)
(kill supersaw)

(cs80lead)
(ctl cs80lead :vibrate 16 :freq (note->hz :a3))
(kill cs80lead)

(simple-flute)
(ctl simple-flute :freq (note->hz :e4))

(rise-fall-pad :t 4 :freq (note->hz :e5))

(odoc ctl)

(defn playchord [notes]
  (defn- p [n]
    (overpad :note (note n) :attack 5
             :release 10 :amp 0.3))
  (doall (map p notes)))

(playchord '(:g2 :b2 :d3 :f#3))
(playchord '(:b2 :d3 :g3))

(do 
  (overpad :note (note :g3) :attack 5 :release 10 :amp 0.3)
  (overpad :note (note :b3) :attack 5 :release 10 :amp 0.3)
  (overpad :note (note :d4) :attack 5 :release 10 :amp 0.3)
  )

(kill pad)

;;(stop)
