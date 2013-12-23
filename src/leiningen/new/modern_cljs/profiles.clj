{:dev {:resources-paths ["dev-resources"]
       :dependencies [[com.cemerick/piggieback "0.1.2"]]
       :cljsbuild
       {:builds {:ws
                 {:source-paths ["src/cljs" "dev-resources/tools/repl"]
                  :compiler
                  {:output-to "dev-resources/public/js/ws.js"
                   :output-dir "dev-resources/public/js"
                   :source-map "dev-resources/public/js/ws.js.map"
                   :optimizations :whitespace
                   :pretty-print true}}}}
       :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
       :injections [(require '[cljs.repl.browser :as brepl]
                             '[cemerick.piggieback :as pb])
                    (defn browser-repl []
                      (pb/cljs-repl :repl-env (brepl/repl-env :port 9000)))]}}
