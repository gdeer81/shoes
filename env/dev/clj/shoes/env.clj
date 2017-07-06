(ns shoes.env
  (:require [clojure.tools.logging :as log]
            [shoes.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[precept-shoes started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[precept-shoes has shut down successfully]=-"))
   :middleware wrap-dev})
