(ns clj-hr-prep.luck-balance-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.luck-balance :refer :all]))

(def expected [29 42 21])

(deftest luckBalanceTest
  (is (= expected (run inputs))))
