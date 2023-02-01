(ns clj-hr-prep.polygon-perimeter-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.polygon-perimeter :refer :all]))

(def roundP #(format "%.7f" %))
(def formatP #(Double/parseDouble %))
(def formatR #(-> % roundP formatP))

(deftest polygonPerimeterTestInput1
  (is (= expected1 (formatR (perimeter input1)))))

(deftest polygonPerimeterTestInput2
  (is (= expected2 (formatR (perimeter input2)))))
