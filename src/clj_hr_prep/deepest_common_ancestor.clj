(ns clj-hr-prep.deepest-common-ancestor)

(def inputs [[[4 2 3 1 7 6] [1 7]]
             [[1 2] [1 2]]
             [[5 3 8 2 4 6 7] [7 3]]])

(defn find-path
  ([tree q] (find-path tree q []))
  ([tree q path]
   (let [{:keys [value left right]} tree]
     (cond (= q value) {:found q :path (conj path q)}
           (and (not left) (not right)) nil
           (and (> q value) right) (find-path right q (conj path value))
           (and (< q value) left) (find-path left q (conj path value))))))

(defn lca [tree v1 v2]
  (let [{p1 :path} (find-path tree v1)
        {p2 :path} (find-path tree v2)
        vals (reverse (for [x p1 y p2] [(= x y) x]))]
    (reduce
      (fn [a v]
        (if (get v 0)
          (reduced (get v 1))
          nil))
      nil vals)))