(ns clj-hr-prep.count-swaps-bubble-sort)

(def inputs [[1 2 3]
             [3 2 1]
             [4 2 3 1]])

(defn- bubble [{c :c ys :is} x]
  (if-let [y (peek ys)]
    (if (> y x)
      {:c (inc c) :is (conj (pop ys) x y)}
      {:c c :is (conj ys x)})
    {:c c :is [x]}))

(defn bubble-sort
  "Idiomatic bubble sort implementation by https://eddmann.com/posts/bubble-sort-in-clojure/"
  [xs]
  (loop [c 0 zs xs]
    (let [{ys :is n :c} (reduce bubble {:c 0 :is []} zs)]
     (if (= zs ys)
       {:c c :is zs}
       (recur (+ n c) ys)))))

(defn countSwaps
  "https://www.hackerrank.com/challenges/ctci-bubble-sort/problem"
  [a]
  (let [result (bubble-sort a)
        count (:c result)
        xs (:is result)
        p0 (first xs)
        plast (peek xs)
        messages [(format "Array is sorted in %d swaps." count)
                  (str "First Element: " p0)
                  (str "Last Element: " plast)]]
    (doseq [message messages]
      (println message))))