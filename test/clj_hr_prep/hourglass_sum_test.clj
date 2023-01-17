(ns clj-hr-prep.hourglass-sum-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.hourglass-sum :refer :all]))

(deftest hourglassSumTest
  (testing "array2d1"
    (is (= 19 (hourglassSum array2d1))))
  (testing "array2d2"
    (is (= 13 (hourglassSum array2d2))))
  (testing "array2d3"
    (is (= 28 (hourglassSum array2d3)))))
