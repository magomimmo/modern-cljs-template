{:dev {;; set :clean-targets to delete the "out" directory created by brepl
       :clean-targets ["out" :target-path]
       ;; add both clj and cljs sources
       :source-paths ["dev-resources/tools/http" "dev-resources/tools/repl"]
       ;; add dependencies for running the http server
       :dependencies [[ring "1.2.1"]
                      [compojure "1.1.6"]
                      [enlive "1.1.4"]]
       ;; add austing for brepling
       :plugins [[com.cemerick/austin "0.1.3"]]
       ;; inject the required namespaces to run the server
       ;; inject the browser-repl definition to run the brepl
       :injections [(require '[ring.server :as http :refer [run]]
                             'cemerick.austin.repls)
                    (defn browser-repl []
                      (cemerick.austin.repls/cljs-repl (reset! cemerick.austin.repls/browser-repl-env
                                                               (cemerick.austin/repl-env))))]
       :cljsbuild
       {:builds {;; development build
                 :dev
                 ;; add the brepl/connect.cljs to connect the brepl
                 {:source-paths ["src/cljs" "dev-resources/tools/repl"]
                  :compiler
                  {:output-to "resources/public/js/main.js"
                   :output-dir "resources/public/js"
                   ;; support for source-map (Google Chrome only)
                   :source-map "resources/public/js/main.js.map"
                   :optimizations :whitespace
                   :pretty-print true}}}}}}
