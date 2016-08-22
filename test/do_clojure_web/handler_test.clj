(ns do-clojure-web.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [do-clojure-web.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (string? (:body response)))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
