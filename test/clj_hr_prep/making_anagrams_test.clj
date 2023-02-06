(ns clj-hr-prep.making-anagrams-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.making-anagrams :refer :all]))

(def expected [4 30 2 107])
(def inputs [input1 input2 input3 input14])

(deftest makeAnagramTest
  (is (= expected (map #(apply makeAnagram %) inputs))))
