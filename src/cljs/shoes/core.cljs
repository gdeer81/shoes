(ns shoes.core
  (:require [reagent.core :as r]
            [mount.core :as mount]
            [shoes.rules :refer [app-session]]
            [shoes.views :as views]
            [shoes.ws :as ws]
            [precept.core :refer [start!]]))


(defn mount-components []
  (r/render #'views/app (.getElementById js/document "app")))

(defn init! []
  (mount/start)
  (start! {:session app-session :facts [[:transient :start true]]})
  (mount-components))
