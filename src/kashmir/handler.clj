(ns kashmir.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.util.response :as rr]
            [kashmir.logic :as logic]))

(defroutes api-routes
    (GET "/" [] "Hello World")
    (GET "/members/:id{[0-9]+}" [id]
         (rr/response (logic/find-member (read-string id))))
    (route/not-found "Not Found"))

(def app
    (wrap-defaults api-routes api-defaults))
