(ns clj-hr-prep.ransom-note)

(def input0 {:m ["give" "me" "one" "grand" "today" "night"]
             :n ["give" "one" "grand" "today"]})

(def input1 {:m ["ive" "got" "a" "lovely" "bunch" "of" "coconuts"]
             :n ["ive" "got" "some" "coconuts"]})

(def input2 {:m ["two" "times" "three" "is" "not" "four"]
             :n ["two" "times" "two" "is" "four"]})

(defn checkMagazineBoolean [magazine note]
  (let [mWordCount (reduce
                     (fn [m word]
                       (assoc! m word (+ 1 (get m word 0))))
                     (transient {})
                     magazine)
        result (reduce
                 (fn [[result m] word]
                   (let [value (get mWordCount word 0)
                         found (> value 0)]
                     (if (not found)
                       (reduced [false m])
                       [result (assoc! m word (dec (get m word 0)))])))
                 [true mWordCount]
                 note)]
    (get result 0)))

(defn checkMagazine
  "https://www.hackerrank.com/challenges/ctci-ransom-note/problem"
  [magazine note]
  (println
    (if (checkMagazineBoolean magazine note)
      "Yes"
      "No")))

