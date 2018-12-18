(ns overtone-loops.loops-test
  (:use [overtone.live]
        [overtone.inst.piano])
  (:require [clojure.test :refer :all]
            [overtone-loops.loops :refer :all]))


(deftest thunk-tests
  (testing "Thunks"
    (is (fn? (thunk (+ 1 2))))))


(deftest pairer-tests
  (testing "pairer works on simple lists"
    (is (= '((1 2) (3 4) (5 6) (7 8))
           (pairer '(1 2 3 4 5 6 7 8)))))
  (testing "handles odd number of items"
    (is (= '((1 2) (3 4) (5 nil)))
           (pairer '(1 2 3 4 5)))))


(deftest add-instr-tests
  (let [pairs '(0 (:vel 50)
                  1 (:vel 70)
                  2 (:vel 85)
                  3 (:vel 100))]

    (testing "timings passed through OK"
      (is (= 0
             (first (add-instr piano pairs))))
      (is (= 1
             (nth (add-instr piano pairs) 2))))

    (testing "options become a function"
      (is (fn? (second (add-instr piano pairs))))
      (is (fn? (nth (add-instr piano pairs) 5))))))

            
