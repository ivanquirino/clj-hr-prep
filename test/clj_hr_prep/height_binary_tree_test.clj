(ns clj-hr-prep.height-binary-tree-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.height-binary-tree :refer [run-inputs]]))

(deftest height-binary-tree-test
  (is (= [3 0 3 9 3] (run-inputs))))