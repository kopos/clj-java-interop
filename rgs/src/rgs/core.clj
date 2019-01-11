(ns rgs.core
  (:require [rgs.loader :refer [getInstance]])
  (:gen-class
    :name Platform))

(defn get-dyn-obj [jar fqcn]
  (let [obj (getInstance jar fqcn)]
    (println (.doAction obj 5))))

(defn -main
  [& args]
  (println "Platform: Hello, World!")
  (get-dyn-obj "../vendor/vendor.jar" "Game"))
