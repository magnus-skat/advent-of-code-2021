(ns advent-of-code-2021.core
  (:require [clojure.string :as str])
  )

(defn day1-a
  "Solution Day 1, part One"
  []
  (let [solution (atom 0)
        i (atom 1)
        problem (map #(Integer/parseInt %) (str/split-lines (slurp "resources/day1-a")))
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

(defn- sumvec
  [i coll]
  (apply + (subvec (vec coll) i  (+ i 3)))
  )


(defn day1-b
  "Solution Day 1, Part Two"
  []
  (let [problem (map #(Integer/parseInt %) (str/split-lines (slurp "resources/day1-a")))
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