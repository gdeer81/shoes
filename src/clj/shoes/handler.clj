(ns shoes.handler
    (:require [compojure.core :refer [routes wrap-routes]]
              [shoes.routes.home :refer [home-routes]]
              [shoes.routes.ws :refer [ws-routes]]
              [compojure.route :as route]
              [shoes.env :refer [defaults]]
              [mount.core :as mount]
              [shoes.routes.api :refer [api-routes]]
              [shoes.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    #'ws-routes
    (-> #'api-routes (wrap-routes middleware/wrap-formats))
    (-> #'home-routes (wrap-routes middleware/wrap-formats))
    (route/not-found {:status 404})))

(defn app [] (middleware/wrap-base #'app-routes))
