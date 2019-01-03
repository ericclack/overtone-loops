(ns overtone-loops.music.music-26dec18-2
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [clojure.pprint :refer [pp pprint]]
            [overtone-loops.loops
             :refer [defloop metro on-next-bar
                     defphrase]]))

;; Define some samples from Freesound.org
(def kick (freesound 171104))
(def snare0 (freesound 151689))
(def hat (freesound 404890))

;;(snare0)
;;(snare)

(definst snare
  [amp 1]
  (let [env     (env-gen (perc 0.01 1.1) :action FREE)
        snd     (play-buf 1 snare0)]
    (* amp env snd)))

(comment
  (kick)
  )

(defloop ticks 4
  0 (hat :amp 0.8)
  1 (hat :amp 0.4)
  2 (hat :amp 0.6)
  3 (hat :amp 0.4)
  )

(defloop kicks1 8
  0 (kick :amp 0.6)
  1 (kick :amp 0.5)

  4 (kick :amp 0.6)
  5 (kick :amp 0.6)
  ) 

(defloop extra-kicks 4
  4.6 (kick :amp 0.4)
  )

(defloop snares1 8
  2 (snare :amp 1)

  6 (snare :amp 1)
  )

(defloop extra-snares 8
  5.333 (snare :amp 0.5)
  )


(defphrase melody-phrase1
  0 (piano (note :d4) :decay 0 :vel 80)
  1 (piano (note :f4))
  4 (piano (note :g4) :decay 0 :vel 80)
  5 (piano (note :d4))

  8 (piano (note :d4) :vel 80)
  8.66 (piano (note :c4))
  9 (piano (note :d4) :vel 80)
  9.66 (piano (note :c4))
  
  10 (piano (note :f4) :decay 0)
  11 (piano (note :d4))

  12 (piano (note :bb3))
  )

(defphrase melody-phrase2
  0 (piano (note :d4) :decay 0 :vel 80)
  1 (piano (note :f4))
  4 (piano (note :g4) :decay 0 :vel 80)
  5 (piano (note :d4))

  8 (piano (note :d4) :vel 80)
  8.66 (piano (note :c#4))
  9 (piano (note :d4) :vel 80)
  9.66 (piano (note :c#4))
  
  10 (piano (note :d4) :decay 0)
  11 (piano (note :c#4))

  12 (piano (note :c4))
  )

;; ---------------------------------------------

(metro-bpm metro 120)
  
(defn in-bars [bars beats-per-bar]
  (+ (* bars beats-per-bar) (metro)))

(do
  (ticks (metro))
  (kicks1 (metro))
  (snares1 (metro))
  )

(comment
  (extra-kicks (on-next-bar 8) 4)
  (extra-snares (on-next-bar 8) 4)
  )

(comment
  (melody-phrase1 (on-next-bar 8))
  (melody-phrase2 (on-next-bar 8))
  )

;;(stop)

