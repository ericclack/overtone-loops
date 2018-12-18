(ns overtone-loops.loops-test
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [clojure.test :refer :all]
            [overtone-loops.loops :refer :all]))


(deftest thunk-tests
  (testing "Thunks"
    (is (fn? (thunk (+ 1 2))))
    (is (= 2 ((thunk (+ 1 1)))))))


(deftest pairer-tests
  (testing "pairer works on simple lists"
    (is (= '((1 2) (3 4) (5 6) (7 8))
           (pairer '(1 2 3 4 5 6 7 8)))))
  (testing "handles odd number of items"
    (is (= '((1 2) (3 4) (5 nil)))
           (pairer '(1 2 3 4 5)))))


(deftest thunkify-tests
  (testing "a"
    (let [pairs (thunkify-pairs ((0 (print "at 0"))
                                 (1 (print "at 1"))))]
      (is (= 0 (first pairs)))
      (is (= 1 (nth pairs 2))))))
           
