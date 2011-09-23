(ns redbridge-demo.core
  (:require [ring.adapter.jetty :as jetty]
            [redbridge-demo.haml :as haml]))

;; (defn app [req]
;;   {:status 200
;;    :headers {"ContentType" "text/html"}
;;    :body (haml/render req)})

(defn -main []
  (jetty/run-jetty app {:port 8080}))