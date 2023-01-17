(ns clj-hr-prep.core-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.core :refer :all]))

(deftest sockMerchantTest
  (testing "10 20 20 10 10 30 50 10 20"
    (is (= 3 (sockMerchant 9 [10 20 20 10 10 30 50 10 20]))))
  (testing "1 1 3 1 2 1 3 3 3 3"
    (is (= 4 (sockMerchant 10 [1 1 3 1 2 1 3 3 3 3])))))

(deftest countingValleysTest
  (testing "8 UDDDUDUU"
    (is (= 1 (countingValleys 8 "UDDDUDUU"))))
  (testing "12 DDUUDDUDUUUD"
    (is (= 2 (countingValleys 12 "DDUUDDUDUUUD")))))

(deftest repeatedStringTest
  (testing "10 aba"
    (is (= 7 (repeatedString "aba" 10))))
  (testing "1000000000000 a"
    (is (= 1000000000000 (repeatedString "a" 1000000000000)))))

(deftest jumpingOnCloudsTest
  (testing "[0 0 1 0 0 1 0]"
    (is (= 4 (jumpingOnClouds [0 0 1 0 0 1 0]))))
  (testing "[0 0 0 1 0 0]"
    (is (= 3 (jumpingOnClouds [0 0 0 1 0 0])))))

