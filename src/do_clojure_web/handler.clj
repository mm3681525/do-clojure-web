(ns do-clojure-web.handler
  (:require [do-clojure-web.views :as views]
            [compojure.core :as cc]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty])
  (:gen-class))

(cc/defroutes app-routes
  (cc/GET "/"
          []
          (views/home-page))
  (cc/GET "/add-location"
          []
          (views/add-location-page))
  (cc/POST "/add-location"
           {params :params}
           (views/add-location-results-page params))
  (cc/GET "/location/:loc-id"
          [loc-id]
          (views/location-page loc-id))
  (cc/GET "/all-locations"
          []
          (views/all-locations-page))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main
  [& [port]]
  (let [port (Integer. (or port
                           (System/getenv "PORT")
                           5000))]
    (jetty/run-jetty #'app {:host  "0.0.0.0"
                            :port  port
                            :join? false})))
