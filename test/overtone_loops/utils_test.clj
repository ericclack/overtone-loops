(ns overtone-loops.utils-test
  (:require [clojure.test :refer :all]
            [overtone-loops.utils :refer :all]))


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


(deftest map-odds-evens-tests
  (testing "a"
    (is (= '(2 2 4 4 6 6)
           (map-odds inc '(1 2 3 4 5 6))))
    (is (= '(1 3 3 5 5 7)
           (map-evens inc '(1 2 3 4 5 6))))

    ))
  
