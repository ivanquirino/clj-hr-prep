(ns count_swaps_bubble_sort_test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.count-swaps-bubble-sort :refer :all]))

(def expected [0 3 5])

(deftest countSwapsBubbleSortTest
  (is (= expected (map #(:c (bubble-sort %)) inputs))))
