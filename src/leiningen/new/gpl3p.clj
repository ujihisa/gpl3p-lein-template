(ns leiningen.new.gpl3p
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "gpl3p"))

(defn gpl3p
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["project.clj" (render "project.clj" data)])))
