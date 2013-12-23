(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.3.4"

  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2127"]
                 [compojure "1.1.6"]]

  :plugins [[lein-cljsbuild "1.0.1"]
            [lein-ring "0.8.8"]]

  :hooks [leiningen.cljsbuild]

  :ring {:handler {{namespace}}/handler}

  :cljsbuild {:builds
              {:{{name}}
               {:source-paths ["src/cljs"]
                :compiler
                {:output-to "resources/public/js/{{name}}.js"
                 :output-dir "resources/public/js/"
                 :source-map "resources/public/js/{{name}}.js.map"
                 :optimizations :whitespace
                 :pretty-print true}}}})
