(ns ring.server
  (:require [cemerick.austin.repls :refer (browser-connected-repl-js)]
            [net.cgrand.enlive-html :as enlive]
            [compojure.route :refer  (resources)]
            [compojure.core :refer (GET defroutes)]
            [ring.adapter.jetty :as jetty]
            [clojure.java.io :as io]))

(enlive/deftemplate page
  (io/resource "public/index.html")
  []
  [:div.mainjs] (enlive/substitute 
                 (enlive/html [:div.mainjs
                               [:script {:src "js/main.js"}]
                               [:script (browser-connected-repl-js)]])))

(defroutes site
  (resources "/")
  (GET "/*" req (page)))

(defn run
  "Run the ring server. It defines the server symbol with defonce."
  []
  (defonce server
    (jetty/run-jetty #'site {:port 3000 :join? false}))
  server)