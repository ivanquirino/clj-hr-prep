(ns clj-hr-prep.deepest-common-ancestor-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.deepest-common-ancestor :refer :all]
            [clj-hr-prep.height-binary-tree :refer [create-tree]]))

(def expected [4 1 5])

(deftest deepestCommonAncestorTest
  (is (= expected
         (map (fn [[values [v1 v2]]]
                (lca (create-tree values) v1 v2)) inputs))))
