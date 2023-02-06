(ns clj-hr-prep.maximum-toys)

(def inputs [{:budget 50, :prices [1 12 5 111 200 1000 10]}
             {:budget 7, :prices [1 2 3 4]}
             {:budget 15, :prices [3 7 2 9 4]}])

(defn maximumToys [prices k]
  (let [sortedPrices (sort prices)]
    (:n (reduce
          (fn [{b :budget, n :n} v]
            (if (<= v b)
              {:n (inc n) :budget (- b v)}
              {:n n, :budget b}))
          {:budget k, :n 0} sortedPrices))))
