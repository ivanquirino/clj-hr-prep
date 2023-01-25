(ns clj-hr-prep.ransom_note_test
  (:require [clojure.test :refer :all]
            [clj-hr-prep.ransom-note :refer :all]))

(deftest ransomNoteTest
  (let [actual (for [input [input0 input1 input2] :let [{m :m n :n} input]] (checkMagazineBoolean m n))
        expected [true false false]]
    (is (= actual expected))))