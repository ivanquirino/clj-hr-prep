(ns clj-hr-prep.alternating-characters)

(def inputs ["AAAA"
             "BBBBB"
             "ABABABAB"
             "BABABA"
             "AAABBB"
             "AAABBBAABB"
             "AABBAABB"
             "ABABABAA"
             "ABBABBAA"])

(defn alternatingCharacters
  "https://www.hackerrank.com/challenges/alternating-characters/problem"
  [s]
  (:c (reduce
        (fn [a v]
          (if (= v (:s a))
            (assoc a :c (inc (:c a)) :s v)
            (assoc a :s v)))
        {:c 0 :s (first s)} (rest s))))