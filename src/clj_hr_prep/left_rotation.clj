(ns clj-hr-prep.left-rotation
  (:require [clojure.string :as str]))

(def input1 {:a [1 2 3 4 5] :d 4 })
(def input2 {:a [41 73 89 7 10 1 59 58 84 77 77 97 58 1 86 58 26 10 86 51] :d 10})
(def input3 {:a [33 47 70 37 8 53 13 93 71 72 51 100 60 87 97] :d 13})

(defn rotateLeftOnce [a]
  (conj (vec (rest a)) (first a)))

(defn rotLeft [a d]
  (loop [i 0 v a]
    (if (>= i d)
      (str/join " " v)
      (recur (inc i) (rotateLeftOnce v)))))
