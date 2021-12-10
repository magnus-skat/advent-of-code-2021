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

(defn most-common
  [problem position]
  (let [freq (->> problem
                  (map  #(nth % position))
                  frequencies )
        zeroes (-> freq first second)
        ones (-> freq second second)
        ]
    (if (= ones zeroes)
      \1
      (->> freq
           (sort-by second)
           second
           first
           )
      )
    )
  )

(defn least-common
  [problem position]
  (let [freq (->> problem
             (map  #(nth % position))
             frequencies )
        zeroes (-> freq first second)
        ones (-> freq second second)
        ]
    (if (= ones zeroes)
      \0
      (->> freq
       (sort-by second)
       first
       first
       )
      )
    )
)

(defn filter-funktion
  [problem placement charector]
  (filter #(= (nth % placement) charector) problem)
  )

(defn day3-b
  []
  (let [problem (load-from-file "day3")
        p2 (atom problem)
        p3 (atom problem)
        problem-length (count (first problem))
        ]
    (loop [i 0]
      (when (< i problem-length)
        (let [most-common-char (most-common @p2 i)]
          (reset! p2 (filter-funktion @p2 i most-common-char))
          )
        (recur (inc i))))

    (loop [i 0]
      (when (< i problem-length)
        (let [least-common-char (least-common @p3 i)]
          (reset! p3 (filter-funktion @p3 i least-common-char))
          )
        (recur (inc i))))

    (def maxi (->> @p2
                       seq
                       (apply str)
                       (str "2r")
                       read-string
                      ))
    (def mini (->> @p3
                  seq
                  (apply str)
                  (str "2r")
                  read-string
                  )
    )
    (* mini maxi)
    ))

