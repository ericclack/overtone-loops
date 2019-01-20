(ns overtone-loops.music.jazz1
  (:use [overtone.live]
        [overtone.inst.piano]
        [overtone-loops.loops]))

;; Define some samples from Freesound.org
(def kick (freesound2 171104))
(def snare (freesound2 151689))
(def hat (freesound2 404890))

(defloop ticks 4
  0 (hat :amp 0.8)
  1 (hat :amp 0.4)
  2 (hat :amp 0.6)
  3 (hat :amp 0.4)
  )

(defloop kicks 4
  4.6 (kick :amp 0.4)
  )

(defloop snares1 8
  2 (snare :amp 1)
  5.333 (snare :amp 0.5)
  6 (snare :amp 1)
  )

(defphrase melody-phrase1
  0 (piano (note :d4) :decay 0 :vel 80)
  0.8 (piano (note :e4) :decay 0 :vel 70)
  1 (piano (note :f4))
  3.8 (piano (note :f#4) :decay 0 :vel 70)
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
;; (melody-phrase1 (metro))

(defphrase melody-phrase2
  0 (piano (note :d4) :decay 0 :vel 80)
  1 (piano (note :f4))
  4 (piano (note :g4) :decay 0 :vel 80)
  4.344 (piano (note :f4) :decay 0 :vel 50)
  4.66 (piano (note :e4) :decay 0 :vel 60)
  5 (piano (note :d4))

  8 (piano (note :d4) :vel 80)
  8.66 (piano (note :c#4))
  9 (piano (note :d4) :vel 80)
  9.66 (piano (note :c#4))
  
  10 (piano (note :d4) :decay 0)
  11 (piano (note :c#4))

  12 (piano (note :c4))
  )
;; (melody-phrase2 (metro))

;; ---------------------------------------------

(bpm 120)
(beats-in-bar 8)

(at-bar 1
        (ticks)
        (snares1)
        (kicks)
  )

(at-bar 3
        (melody-phrase1)
        )

(at-bar 5
        (melody-phrase2)
        )

;;(stop)

