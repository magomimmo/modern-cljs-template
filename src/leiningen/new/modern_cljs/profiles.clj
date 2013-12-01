{:dev {:resources-paths ["dev-resources"]
       :test-paths ["test/clj"]
       :source-paths ["dev-resources/tools/http" 
                      "dev-resources/tools/repl"]
       
       :dependencies [[ring "1.2.1"]
                      [enlive "1.1.4"]]

       :plugins [[com.cemerick/austin "0.1.3"]]
       
       :cljsbuild 
       {:builds 
        {:dev
         {:source-paths ["src/cljs" 
                         "dev-resources/tools/repl"]
          :compiler
          {:output-dir "dev-resources/public/js"
           :output-to "dev-resources/public/js/{{name}}-dev.js"
           :source-map "dev-resources/public/js/{{name}}-dev.js.map"
           :optimizations :whitespace
           :pretty-print true}}}}

       :injections [(require '[ring.server :as http :refer [run]]
                             'cemerick.austin.repls)
                    (defn browser-repl []
                      (cemerick.austin.repls/cljs-repl (reset! cemerick.austin.repls/browser-repl-env
                                                               (cemerick.austin/repl-env))))]}}

