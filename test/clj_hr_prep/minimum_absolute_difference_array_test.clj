(ns clj-hr-prep.minimum-absolute-difference-array-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.minimum-absolute-difference-array :refer :all]))

(def inputs [[3 -7 0]
             [-59 -36 -13 1 -53 -92 -2 -96 -54 75]
             [1 -3 71 68 17]])

(def expected [3 1 3])

(deftest minimumAbsoluteDifferenceTest
  (is (= expected (map minimumAbsoluteDifference inputs))))

