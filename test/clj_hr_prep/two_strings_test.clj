(ns clj-hr-prep.two-strings-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.two-strings :refer :all]))

(deftest twoStringsTest
  (let [actual (map (fn [[s1 s2]] (twoStringsBoolean s1 s2)) inputs)
        expected [true false false true true false true false]]
    (is (= actual expected))))
