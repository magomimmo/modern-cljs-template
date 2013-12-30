(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  ;; src/cljs dir is needed
  :source-paths ["src/clj" "src/cljs"]

  ;; add latest available CLJS compiler
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2127"]]

  ;; add support for calling the CLJS compiler
  :plugins [[lein-cljsbuild "1.0.1"]]

  ;; hook cljsbuild to lein task
  :hooks [leiningen.cljsbuild]

  ;; cljsbuild configuration
  :cljsbuild {:builds
              {;; the build name
               :{{name}}

               {;; cljs source dir
                :source-paths ["src/cljs"]

                ;; google closure compiler options
                :compiler

                {;; emitted JS file
                 :output-to "resources/public/js/{{name}}.js"

                 ;; google closure optimizations
                 :optimizations :advanced}}}})
