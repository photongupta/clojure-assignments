(ns assignments.practice)

(defn
  prime?
  [n]
  (->> (range 2 n)
       (filter #(zero? (rem n %)))
       (empty?)))

(defn
  assendingSeq?
  [coll]
   (every? true? (map < coll (rest coll))))

(defn 
  sum-of-greater-seq
  [seq]
  (->> seq
       (partition-by zero?)
       (map (partial apply +))
       (reduce max)))

