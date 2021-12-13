(ns advent-of-code-2021.day4
  (:require [clojure.string :as str]))

(defn load-from-file [filename]
  (slurp (str "resources/" filename)))


(defn day4-a
  []
  (let [problem (load-from-file "day4")
        numbers (->
                  "day4"
                  load-from-file
                  str/split-lines
                  first
                  (str/split #",")
                  )

        f (fn [i] (subvec (str/split-lines problem ) i (+ i 5) ))
        boards (map f (range 2 601 6))
        ]
    boards
    )
  )
