(ns redbridge-demo.haml
  (:require [redbridge-demo.ruby :as rb]))

(def haml-engine
  (do
    (rb/require-gems "rubygems" "haml-3.1.3/gem/haml")
    (rb/rb "Haml::Engine")))

(defn hamlize [haml]
  (rb/call-method haml-engine "new" haml))

(comment
  (defn haml->html [haml-dir html-dir]
    nil))