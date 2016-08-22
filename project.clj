(defproject do-clojure-web "0.1.0"
  :description "do-clojure-web: sample web app for deployment test"
  :url "https://github.com/chadhs/do-clojure-web"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [hiccup "1.0.2"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [com.h2database/h2 "1.3.170"]
                 [ring/ring-jetty-adapter "1.3.2"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler do-clojure-web.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :main do-clojure-web.handler
  :aot [do-clojure-web.handler])
