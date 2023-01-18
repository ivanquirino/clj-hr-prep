(ns clj-hr-prep.hourglass-sum)

(def array2d1
  [[1 1 1 0 0 0]
   [0 1 0 0 0 0]
   [1 1 1 0 0 0]
   [0 0 2 4 4 0]
   [0 0 0 2 0 0]
   [0 0 1 2 4 0]])

(def array2d2
  [[1 1 1 0 0 0]
   [0 1 0 0 0 0]
   [1 1 1 0 0 0]
   [0 9 2 -4 -4 0]
   [0 0 0 -2 0 0]
   [0 0 -1 -2 -4 0]])

(def array2d3
  [[-9 -9 -9 1 1 1]
   [0 -9 0 4 3 2]
   [-9 -9 -9 1 2 3]
   [0 0 8 6 6 0]
   [0 0 0 -2 0 0]
   [0 0 1 2 4 0]])

(defn hourglassSum [arr]
  (let [coords (for [i (range 4) j (range 4)] [i j])
        getHourglass (fn [i j arr]
                       (flatten
                         [(subvec (arr i) j (+ j 3))
                          ((arr (+ i 1)) (+ j 1))
                          (subvec (arr (+ i 2)) j (+ j 3))]))]
    (loop [coordsList coords maxSum -63]
      (if (empty? coordsList)
        maxSum
        (let [coord (first coordsList)
              i (coord 0)
              j (coord 1)
              hourGlass (getHourglass i j arr)
              sum (apply + hourGlass)
              nextMax (if (> sum maxSum) sum maxSum)]
          (recur (rest coordsList) nextMax))))))