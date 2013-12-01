(ns {{name}}.core
    (:require [compojure.core :refer [defroutes GET]]
              [compojure.route :refer [resources not-found]]
              [compojure.handler :refer [site]]))

(defroutes app-routes
  (GET "/" [] "<p>Hello from compojure</p>")
  (resources "/")
  (not-found "Page not found"))

(def handler
  (site app-routes))

