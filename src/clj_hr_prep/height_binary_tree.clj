(ns clj-hr-prep.height-binary-tree)

(def inputs [[3 5 2 1 4 6 7]
             [15]
             [3 1 7 5 4]
             [1 3 2 5 4 6 7 9 8 11 13 12 10 15 14]
             [4 1 8 10 9 3]])

(defn leaf? [node]
  (let [left (:left node) right (:right node)]
    (and (nil? left) (nil? right))))

(defn insert
  ([value] {:value value, :left nil, :right nil})
  ([root value]
   (let [node (insert value)
         {rootVal :value} root
         insertKey (if (< value rootVal) :left :right)]
     (if (nil? (insertKey root))
       (assoc root insertKey node)
       (assoc root insertKey (insert (insertKey root) value))))))

(defn create-tree [values]
  (reduce insert (insert (first values)) (rest values)))

(defn height-recur [height tree]
  (if (leaf? tree)
    (+ height 0)
    (let [h-left (+ height (height-recur 1 (:left tree)))
          h-right (+ height (height-recur 1 (:right tree)))]
      (if (> h-right h-left) h-right h-left))))

(defn get-height
  "https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem"
  [tree]
  (height-recur 0 tree))

(defn run-inputs []
  (map #(-> % create-tree get-height) inputs))