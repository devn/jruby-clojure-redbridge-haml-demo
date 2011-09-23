(ns redbridge-demo.ruby
  (:require [clojure.contrib.io :as io])
  (:import [org.jruby CompatVersion]
           [org.jruby.embed ScriptingContainer LocalContextScope]))

(defn set-container-version [container]
  (. container setCompatVersion
     (. CompatVersion RUBY1_9)))

(def container
  (let [container (ScriptingContainer. LocalContextScope/SINGLETHREAD)]
    (do (set-container-version container)
        container)))

(defn execute [rb-string]
  (. container runScriptlet rb-string))

(defn require-gem [gem]
  (rb (str "require '" gem "'")))

(defn require-gems [& gems]
  (doseq [gem gems]
    (require-gem gem)))

(defn call-method
  ([obj method]
     (. container callMethod obj method Object))
  ([obj method arg]
     (. container callMethod obj method arg Object)))

;; (defn methods->kws [obj]
;;   (map #(keyword (call-method % "to_s"))
;;        (call-method obj "methods")))