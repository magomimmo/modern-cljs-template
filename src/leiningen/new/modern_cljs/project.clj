(defproject {{name}} "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}

  :min-lein-version "2.2.0"

  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2080"]
                 [compojure "1.1.6"]]

  :plugins [[lein-cljsbuild "1.0.0"]
            [lein-ring "0.8.8"]]

  :hooks [leiningen.cljsbuild]

  :ring {:handler {{name}}.core/handler}

  :cljsbuild
  {:builds {:prod
            {:source-paths ["src/cljs"]
             :compiler
             {:output-to "resources/public/js/{{name}}.js"
              :optimizations :advanced
              :pretty-print false}}}})
