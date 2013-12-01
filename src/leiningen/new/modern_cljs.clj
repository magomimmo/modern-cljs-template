(ns leiningen.new.modern-cljs
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "modern-cljs"))

(defn modern-cljs
  "Createa Leiningen project for developing CLJ/CLJS Web Applications"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' modern-cljs project.")
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["doc/intro.md" (render "intro.md" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["project.clj" (render "project.clj" data)]
             ["profiles.clj" (render "profiles.clj" data)]
             ["resources/public/index.html" (render "index.html" data)]
             ["dev-resources/public/index-dev.html" (render "index-dev.html" data)]
             ["dev-resources/tools/repl/brepl/connect.cljs" (render "connect.cljs" data)]
             ["dev-resources/tools/http/ring/server.clj" (render "server.clj")]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["src/clj/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["test/clj/{{sanitized}}/core_test.clj" (render "core_test.clj" data)])))
