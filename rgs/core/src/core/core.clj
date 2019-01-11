(ns core.core
  (:gen-class))

(defn random-int
  [n]
  (rand-int n))

(gen-class
  :name core.lib.rng
  :methods [#^{:static true} [randInt [int] int]])
  
(defn -randInt
  [a]
  (random-int a))
  
(defn -main [& args] (println "Core"))