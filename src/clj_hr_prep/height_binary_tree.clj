(ns clj-hr-prep.height-binary-tree)

(def inputs [[3 5 2 1 4 6 7]
             [15]
             [3 1 7 5 4]
             [1 3 2 5 4 6 7 9 8 11 13 12 10 15 14]
             [4 1 8 10 9 3]])

(defn leaf? [node]
  (let [{left :left right :right} node]
    (and (nil? left) (nil? right))))

(defn insert
  ([value] {:value value, :left nil, :right nil})
  ([tree value]
   (let [node (insert value)
         {treeVal :value} tree
         insertKey (if (< value treeVal) :left :right)]
     (cond (= value treeVal) tree
           (nil? (insertKey tree)) (assoc tree insertKey node)
           :else (assoc tree insertKey (insert (insertKey tree) value))))))

(defn create-tree [values]
  (reduce insert (insert (first values)) (rest values)))

(defn get-height
  "https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem"
  ([tree] (get-height tree 0))
  ([tree height]
   (if (leaf? tree)
     height
     (max (get-height (:left tree) (inc height))
          (get-height (:right tree) (inc height))))))

(defn run-inputs []
  (map #(-> % create-tree get-height) inputs))