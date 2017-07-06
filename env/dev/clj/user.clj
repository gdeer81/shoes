(ns user
  (:require [mount.core :as mount]
            [shoes.figwheel :refer [start-fw stop-fw cljs]]
            [shoes.core]))

(defn start []
  (mount/start-without #'shoes.core/http-server
                       #'shoes.core/repl-server))

(defn stop []
  (mount/stop-except #'shoes.core/http-server
                     #'shoes.core/repl-server))

(defn restart []
  (stop)
  (start))


