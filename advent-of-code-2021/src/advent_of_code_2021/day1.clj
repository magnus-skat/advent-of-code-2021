(ns advent-of-code-2021.day1
  (:require [clojure.string :as str]
            )
  )
(defn- load-from-file [filename]
  (map #(Integer/parseInt %) (str/split-lines (slurp (str "resources/" filename)))))

(defn- sumvec
  [i coll]
  (apply + (subvec (vec coll) i  (+ i 3)))
  )

(defn day1-a
  "Solution Day 1, part One"
  []
  (let [solution (atom 0)
        i (atom 1)
        problem (load-from-file "day1-a")
        ]
    (while (< @i (count problem))
      (if (> (nth problem @i) (nth problem (- @i 1)))
        (do
          (swap! solution inc)
          ))
      (swap! i inc)
      )
    @solution
    ))

(defn day1-b
  "Solution Day 1, Part Two"
  []
  (let [problem (load-from-file "day1-a")
        problem (map #(sumvec % problem) (range (- (count problem) 2)))
        solution (atom 0)
        i (atom 1)
        ]
    (while (< @i (count problem))
      (if (> (nth problem @i) (nth problem (- @i 1)))
        (do
          (swap! solution inc)
          ))
      (swap! i inc)
      )
    @solution
    ))