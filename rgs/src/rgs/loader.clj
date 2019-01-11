(ns rgs.loader
  (:import (java.net URL
                     URLClassLoader))
  (:import (java.io File)))

(defn getInstance [jar-path fqcn]
  (let [class-loader (.. Thread currentThread getContextClassLoader)
        jar (.. (File. jar-path) toURI toURL)
        loader (java.net.URLClassLoader/newInstance
                 (into-array URL [jar])
                 class-loader)]
    (.newInstance (.loadClass loader fqcn))))
