(ns clj-hr-prep.ransom-note)

(def input0 { :m ["give" "me" "one" "grand" "today" "night"]
             :n ["give" "one" "grand" "today"] })

(def input1 { :m ["ive" "got" "a" "lovely" "bunch" "of" "coconuts"]
             :n ["ive" "got" "some" "coconuts"] })

(def input2 { :m ["two" "times" "three" "is" "not" "four"]
             :n ["two" "times" "two" "is" "four"]})

(defn checkMagazineBoolean [magazine note]
  (let [mWordCount (reduce
                     (fn [m word]
                       (assoc! m word (+ 1 (get m word 0))))
                     (transient {})
                     magazine)]
    (loop [n note m mWordCount]
      (let [key (first n) value (get m key 0) rNote (rest n) fnd (> value 0)]
        (if (empty? n)
          true
          (if (not fnd)
            false
            (recur rNote (assoc! m key (- value 1)))))))))

(defn checkMagazine [magazine note]
  (println
    (if (checkMagazineBoolean magazine note)
    "Yes"
    "No")))

