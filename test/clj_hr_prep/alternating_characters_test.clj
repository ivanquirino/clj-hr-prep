(ns clj-hr-prep.alternating-characters-test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.alternating-characters :refer :all]))

(def expected [3 4 0 0 4 6 4 1 3])

(deftest alternatingCharactersTets
  (is (= expected (map alternatingCharacters inputs))))
