(ns advent-of-code-2021.day2
(:require [clojure.string :as str]
  ))

(defn- load-from-file [filename]
  (map #(str/split % #" ") (str/split-lines (slurp (str "resources/" filename))))
  )

(def depth (atom 0))
(def position (atom 0))
(def aim (atom 0))


(defn- fs
  [dada]
  (let [retning (first dada)
        afstand (Integer/parseInt (second dada ))
        ]
    (if (= retning "down")
      (swap! depth  #(+ afstand %))
      (if (= retning "up")
        (swap! depth  #(- % afstand))
        (if (= retning "forward")
          (swap! position  #(+ afstand %))
          ))
      )
    )
  )

(defn day2-a
  []
  (let [problem (load-from-file "day2")
        _ (map fs problem)
        ]
    )
  (* @depth @position)
)

(defn- sf
  [dada]
  (let [retning (first dada)
        afstand (Integer/parseInt (second dada ))
        ]
    (if (= retning "down")
      (swap! aim  #(+ afstand %))
      (if (= retning "up")
        (swap! aim  #(- % afstand))
        (if (= retning "forward")
          (do
            (swap! position  #(+ afstand %))
            (swap! depth  #(+ (* afstand @aim) %))))))))

(defn day2-b
  []
  (reset! position 0)
  (reset! depth 0)
  (let [problem (load-from-file "day2")
        _ (map sf problem)
        ]
    )
  (* @depth @position)
  )



