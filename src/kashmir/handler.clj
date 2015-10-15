(ns kashmir.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [kashmir.logic :as logic]))

(defroutes api-routes
    (GET "/" [] "Hello World")
    (GET "/members/:id{[0-9]+}" [id]
         {:status 200
          :headers {"Content-Type" "application/json; charset=utf-8"}
          :body (logic/find-member (read-string id))})
    (route/not-found "Not Found"))

(def app
    (wrap-defaults api-routes api-defaults))
