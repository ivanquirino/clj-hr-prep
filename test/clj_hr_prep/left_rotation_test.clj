(ns clj-hr-prep.left-rotation-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.left-rotation :refer :all]))

(deftest leftRotationTest
  (testing "[1 2 3 4 5]"
    (let [{a :a d :d} input1
          output [5 1 2 3 4]]
      (is (= output (rotLeft a d)))))
  (testing "41 73 89 7 10 1 59 58 84 77 77 97 58 1 86 58 26 10 86 51"
    (let [{a :a d :d} input2
          output [77 97 58 1 86 58 26 10 86 51 41 73 89 7 10 1 59 58 84 77]]
      (is (= output (rotLeft a d)))))
  (testing "[33 47 70 37 8 53 13 93 71 72 51 100 60 87 97]"
    (let [{a :a d :d} input3
          output [87 97 33 47 70 37 8 53 13 93 71 72 51 100 60]]
      (is (= output (rotLeft a d))))))

(deftest leftRotationTest2
  (testing "[1 2 3 4 5]"
    (let [{a :a d :d} input1
          output [5 1 2 3 4]]
      (is (= output (rotLeft2 a d)))))
  (testing "41 73 89 7 10 1 59 58 84 77 77 97 58 1 86 58 26 10 86 51"
    (let [{a :a d :d} input2
          output [77 97 58 1 86 58 26 10 86 51 41 73 89 7 10 1 59 58 84 77]]
      (is (= output (rotLeft2 a d)))))
  (testing "[33 47 70 37 8 53 13 93 71 72 51 100 60 87 97]"
    (let [{a :a d :d} input3
          output [87 97 33 47 70 37 8 53 13 93 71 72 51 100 60]]
      (is (= output (rotLeft2 a d))))))