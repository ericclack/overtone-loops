(ns overtone-loops.examples.phrase1
  "Playing a phrase rather than loops, first 8 bars of Weidmann's Largo 1737"
  (:use [overtone.live]
        [overtone.inst.piano]
        [overtone-loops.loops]))

(defn p
  "Piano player that takes note symbols such as :c
  Other ags:
  gate vel decay release hard velhard muffle velmuff velcurve stereo tune random stretch sustain"
  [note-name & args]
  (apply piano (note note-name) args))

;; (p :c4 :vel 50)
;; (p :d4 :decay 1)

(bpm 60)
(beats-in-bar 3)

(defphrase part1
  0 (p :b3 :vel 100)
  1 (p :c4 :vel 80)
  2 (p :d4 :vel 80)

  3 (p :g3 :vel 100)
  4 (p :f#3)
  5 (p :g3)

  6 (p :c4 :vel 100)
  7 (p :b3)
  7.5 (p :g3)
  8 (p :d4)
  8.5 (p :b3)

  9 (p :b3 :vel 100)
  10 (p :a3 :vel 80 :decay 1)
  ;;
  
  12 (p :g3 :vel 100)
  13 (p :g4)
  14 (p :f#4)
  14.5 (p :e4)

  15 (p :c#4 :vel 100)
  16 (p :d4)
  16.5 (p :a4)
  17 (p :e4)

  18 (p :f#4 :vel 100)
  18.5 (p :d4 :vel 80)
  19 (p :e4 :vel 80 :decay 1)
  ;;

  21 (p :d4 :vel 100 :decay 1.5)
  ;;
  ;;
  )

;; Repeat part 1
(part1 (metro))
(part1 (on-next-bar 8))

;; Part 2
;; TBC

;;
;;(stop)

