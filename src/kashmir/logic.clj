(ns kashmir.logic
  (:require [kashmir.data :as data]
            [cheshire.core :as json]))

(defn find-member [id]
  (json/generate-string (data/find-member id)))
