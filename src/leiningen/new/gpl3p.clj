(ns leiningen.new.gpl3p
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "gpl3p"))

(defn gpl3p
  "Leiningen template for GPL3+ projects, with Clojure exception"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["project.clj" (render "project.clj" data)]
             ["COPYING" (render "COPYING" data)]
             ["LICENSE" (render "LICENSE" data)])))
