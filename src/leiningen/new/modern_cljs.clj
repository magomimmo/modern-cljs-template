(ns leiningen.new.modern-cljs
  (:require [leiningen.new.templates :refer [renderer
                                             year
                                             project-name
                                             sanitize-ns
                                             name-to-path
                                             ->files
                                             multi-segment]]
            [leiningen.core.main :as main]))

(defn modern-cljs
  "A mixed CLJ/CLJS project template"
  [name]
  (let [render (renderer "modern-cljs")
        main-ns (multi-segment (sanitize-ns name))
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :nested-dirs (name-to-path main-ns)
              :year (year)}]
    (main/info "Generating a project called" name "based on the 'modern-cljs' template")
    (->files data
             ;["test/clj/{{nested-dirs}}_test.clj" (render "test.clj" data)]
             ;["test/cljs/{{nested-dirs}}_test.cljs" (render "test.cljs" data)]
             ["profiles.clj" (render "profiles.clj" data)]
             ["doc/intro.md" (render "intro.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["project.clj" (render "project.clj" data)]
             ["src/clj/{{nested-dirs}}.clj" (render "core.clj" data)]
             ["src/cljs/{{nested-dirs}}.cljs" (render "core.cljs" data)]
             ["resources/public/index.html" (render "index.html" data)]
             ["dev-resources/public/index-dbg.html" (render "index-dbg.html" data)]
             ["dev-resources/tools/repl/brepl/connect.cljs" (render "connect.cljs" data)])))
