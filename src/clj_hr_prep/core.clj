(ns clj-hr-prep.core
  (:require [clj-hr-prep.ransom-note :refer :all])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (doseq [input [input0 input1 input2]]
    (let [{m :m n :n} input]
      (println m n (checkMagazine m n)))))

; warmup exercises

(defn sockMerchant [_ ar]
  (let
    [colorCount (reduce (fn [acc curr]
                          (assoc acc curr (if (contains? acc curr) (+ (get acc curr) 1) 1))
                          ) {} ar)
     pairCount (reduce (fn [acc [key value]] (assoc acc key (quot value 2))) {} colorCount)]
    (reduce (fn [acc [_ value]] (+ acc value)) 0 pairCount)))

(defn countingValleys [steps path]
  (let [numberspath (map #(if (= % \U) 1 -1) path)]
    (:valleys
      (reduce
        (fn [{sum :sum valleys :valleys} curr]
          (let [nextSum (+ sum curr)
                nextValleys (if (and (= nextSum 0) (= curr 1)) (+ valleys 1) valleys)]
            {:sum nextSum :valleys nextValleys}))
        {:sum 0 :valleys 0}
        numberspath))))

(defn repeatedString [s n]
  (let [countAs #(if (= %2 \a) (+ %1 1) %1)
        as (reduce countAs 0 s)
        counter (* (quot n (count s)) as)
        remain (reduce countAs 0 (take (mod n (count s)) s))]
    (+ counter remain)))

(defn jumpingOnClouds [c]
  (loop [i 0 numJumps 0]
    (if (>= i (- (count c) 1))
      numJumps
      (let [jump (if (= 1 (get c (+ i 2))) 1 2)]
        (recur (+ i jump) (+ 1 numJumps))))))
