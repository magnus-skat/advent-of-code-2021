(ns advent-of-code-2021.day3
  (:require [clojure.string :as str]
            ))

(defn- load-from-file [filename]
  (str/split-lines (slurp (str "resources/" filename))))


(defn day3-a
  []
  (let [
        problem (load-from-file "day3")
        maxed (read-string (str "2r" (apply str (seq (map (fn [index] (first (second (sort-by second (frequencies (map #(nth % index) problem)))))) (range 12))))))
        mined (read-string (str "2r" (apply str (seq (map (fn [index] (first (first (sort-by second (frequencies (map #(nth % index) problem)))))) (range 12))))))

        ]
    (* maxed mined)))
