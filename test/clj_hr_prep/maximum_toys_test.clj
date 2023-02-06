(ns clj-hr-prep.maximum-toys-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.maximum-toys :refer :all]))

(def expected [4 3 3])
(deftest maximumToysTest
  (is (= expected (map
                    (fn [{budget :budget prices :prices}]
                      (maximumToys prices budget))
                    inputs))))
