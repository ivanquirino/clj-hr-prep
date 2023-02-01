(ns clj-hr-prep.two-strings)

(defn twoStringsBoolean [s1 s2]
  "https://www.hackerrank.com/challenges/two-strings/problem"
  (let [s1map (reduce #(assoc! %1 %2 true) (transient {}) s1)]
    (reduce
      (fn [_ value] (if (get s1map value false)
                      (reduced true)
                      false))
      false
      s2)))

(def inputs [["hello" "world"]
             ["hi" "world"]
             ["wouldyoulikefries" "abcabcabcabcabcabc"]
             ["hackerrankcommunity" "cdecdecdecde"]
             ["jackandjill" "wentupthehill"]
             ["writetoyourparents" "fghmqzldbc"]
             ["aardvark" "apple"]
             ["beetroot" "sandals"]])