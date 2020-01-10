(ns overtone-loops.examples.alternate
  "Simple example heartbeat pattern"
  (:use [overtone.live]
        [overtone-loops.loops]
        [overtone-loops.samples]))

(set-up)
(bpm 120)
(beats-in-bar 4)

;; Our patterns A and B
(def pat-a [5 _ 5 _ 5 _ 5 _])
(def pat-b [5 _ _ 5 _ 4 _ 5])

;; Our loops - both 4 beats to the bar
(defloop beats 1/2 kick pat-a)

;; Schedule
(at-bar 1
        (beats))

(at-bar 3
        (beats pat-b))

(at-bar 5
        (beats pat-a))
                      
;;
(comment
  ;; Control the switch live
  (beats (metro) pat-a)
  (beats (metro) pat-b)
)  

;;(stop)


