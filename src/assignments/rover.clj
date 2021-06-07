(ns assignments.conditions-test)

(def right {:N :E :E :S :S :W :W :N})
(def left {:E :N :S :E :W :S :N :W})
(def steps {:N {:x 0 :y 1} :E {:x 1 :y 0} :S {:x 0 :y -1} :W {:x -1 :y 0}})

(defn turn-right [x y d] [x y (d right)])
(defn turn-left [x y d] [x y (d left)])
(defn move [x y d] [(+ x (:x (d steps))) (+ y (:y (d steps))) d])

(def commands {\L turn-left \R turn-right \M move})

(defn update-position [[x y d] cmd] ((commands cmd) x y d))

(defn move-rover [[postion,cmd]] (reduce update-position postion cmd))

(defn parse [[pos cmd]]
  (let [[x y d] (clojure.string/split pos #" ")]
    [[(Integer/parseInt x) (Integer/parseInt y) (keyword d)] cmd]))

(defn start [inputSeq]
  (map move-rover (map parse (partition 2 (rest inputSeq)))))

(println (start ["5 5","1 2 N","LMLMLMLMM","3 3 E","MMRMMRMRRM"]))