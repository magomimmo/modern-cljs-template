{:dev {:source-paths ["dev-resources/tools/http" "dev-resources/tools/repl"]
       :dependencies [[ring "1.2.1"]
                      [compojure "1.1.6"]
                      [enlive "1.1.4"]]
       :plugins [[com.cemerick/austin "0.1.3"]]
       :injections [(require '[ring.server :as http :refer [run]]
                             'cemerick.austin.repls)
                    (defn browser-repl []
                      (cemerick.austin.repls/cljs-repl (reset! cemerick.austin.repls/browser-repl-env
                                                               (cemerick.austin/repl-env))))]
       :cljsbuild
       {:builds {:dev
                 {:source-paths ["src/cljs" "dev-resources/tools/repl"]
                  :compiler
                  {:output-to "resources/public/js/main.js"
                   :output-dir "resources/public/js"
                   :source-map "resources/public/js/main.js.map"
                   :optimizations :whitespace
                   :pretty-print true}}}}}}
 
