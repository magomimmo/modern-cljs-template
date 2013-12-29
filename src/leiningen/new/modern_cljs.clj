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
             ["resources/public/index.html" (render "index.html" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)])))
