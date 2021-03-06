(ns overtone-loops.loops-human-test
  (:use [overtone.live]
        [overtone.inst.piano]
        [overtone-loops.loops]
        [overtone-loops.samples])
  (:require [clojure.test :refer :all]))


;; eval and listen to test with Ctrl-c Ctrl-t t

(deftest play-bar-pairs-tests
  (testing "Two kicks and a snare"
    (is (some?
         (play-bar-pairs (metro)
                         (list
                          (list 0 kick)
                          (list 1 kick)
                          (list 2 snare)))))))

(deftest play-bar-tests
  (testing "Two kicks and a snare"
    (is (some?
         (play-bar (metro)
                   0 kick
                   0.66 kick
                   1 kick
                   2 snare)))))


;; (stop)
