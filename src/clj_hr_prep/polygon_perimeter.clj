(ns clj-hr-prep.polygon-perimeter)

(defn getSegments [points]
  (loop [sides [] remains points]
    (let [pairOfPoints (vec (take 2 remains))
          c (count pairOfPoints)]
      (if (= c 1)
        (conj sides (conj pairOfPoints (first points)))
        (recur (conj sides pairOfPoints) (rest remains))))))

(defn calcSegmentLength [pairOfPoints]
  (let [[[x1 y1] [x2 y2]] pairOfPoints
        [a b] [(Math/abs (- x2 x1)) (Math/abs (- y2 y1))]]
    (Math/sqrt (+ (* a a) (* b b)))))

(defn perimeter [points]
  "https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon/problem"
  (let [segments (getSegments points)
        segmentsLength (for [s segments] (calcSegmentLength s))]
    (reduce + segmentsLength)))

(def input1 [[1043 770] [551 990] [681 463]])
(def expected1 1556.3949033)
(def input2 [[458 695] [621 483] [877 469] [1035 636] [1061 825] [875 1023] [645 1033] [485 853]])
(def expected2 1847.4805506)