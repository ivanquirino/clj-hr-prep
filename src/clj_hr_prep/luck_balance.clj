(ns clj-hr-prep.luck-balance)

(def inputs [{:k 3, :contests [[5 1] [2 1] [1 1] [8 1] [10 0] [5 0]]}
             {:k 5, :contests [[13 1] [10 1] [9 1] [8 1] [13 1] [12 1] [18 1] [13 1]]}
             {:k 2, :contests [[5 1] [4 0] [6 1] [2 1] [8 0]]}])

(defn unimportant? [[_ imp]] (= imp 0))
(def important? (complement unimportant?))

(defn- getLuckBalance [k importantSorted]
  (reduce
    (fn [[k sum] [v _]]
      (if (> k 0)
        [(dec k) (+ sum v)]
        [k (- sum v)]))
    [k 0]
    importantSorted))

(defn luckBalance
  "https://www.hackerrank.com/challenges/luck-balance/problem
  1. Divide into unimportant and important
  2. Lose all unimportant, sum into luck balance
  3. Lose as many important contests, sum into luck balance
  4. Win the remaining important, subtracting from luck balance"
  [k contests]
    (let [unimportant (filterv unimportant? contests)
          important (filterv important? contests)
          importantSorted (sort-by first > important)
          uLuckBalance (apply + (map (fn [[v _]] v) unimportant))
          [_ iLuckBalance] (getLuckBalance k importantSorted)]
      (+ uLuckBalance iLuckBalance)))

(defn run [inputs]
  (map
    (fn [{k :k, contests :contests}]
      (luckBalance k contests))
    inputs))