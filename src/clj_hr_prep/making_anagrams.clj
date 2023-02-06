(ns clj-hr-prep.making-anagrams
  (:require [clojure.set :as set]))

(def input1 ["cde" "abc"])
(def input2 ["fcrxzwscanmligyxyvym" "jxwtrhvujlmrpdoqbisbwhmgpmeoke"])
(def input3 ["showman" "woman"])
(def input14 ["tttttttttttttttttttttttttttttttttttttsssssssssssssssss"
              "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"])

(defn getCommon [a b]
  (set/intersection (set a) (set  b)))

(defn countRemoveNotCommon [common freq]
  (reduce-kv
    (fn [a k v]
      (if (get common k) a (+ a v)))
    0 freq))

(defn countRemoveCommon [common f1 f2]
  (reduce
    (fn [a v]
      (let [c1 (get f1 v) c2 (get f2 v)]
        (+ a (Math/abs (- c1 c2)))))
    0 common))

(defn makeAnagram
  "https://www.hackerrank.com/challenges/ctci-making-anagrams/problem?"
  [a b]
  (let [f1 (frequencies a) f2 (frequencies b)
        common (getCommon a b)
        notCommonF1 (countRemoveNotCommon common f1)
        notCommonF2 (countRemoveNotCommon common f2)
        countCommon (countRemoveCommon common f1 f2)]
    (+ notCommonF1 notCommonF2 countCommon)))



