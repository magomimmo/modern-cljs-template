(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2127"]]

  :plugins [[lein-cljsbuild "1.0.1"]]

  :hooks [leiningen.cljsbuild]

  :cljsbuild {:builds
              {:{{name}}
               {:source-paths ["src/cljs"]
                :compiler {:output-to "resources/public/js/{{name}}.js"
                           :output-dir "resources/public/js"
                           :optimizations :none
                           :source-map true}}}})
