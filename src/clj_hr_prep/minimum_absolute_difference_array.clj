(ns clj-hr-prep.minimum-absolute-difference-array)


(defn getPairs [arr]
    (loop [pairs [] input arr]
      (let [p0 (first input)
            p1 (second input)
            remain (rest input)]
        (if (or (empty? input) (not p1))
          pairs
          (recur (conj pairs [p0 p1]) remain)))))

(defn minimumAbsoluteDifference [arr]
  (let [sorted (sort arr)
        pairs (getPairs sorted)]
    (reduce
      (fn [a [x y]]
        (let [absDiff (Math/abs (- x y))]
          (if (< absDiff a)
            absDiff
            a)))
      (int (Math/abs (apply - (first pairs))))
      (rest pairs))))