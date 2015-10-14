(ns kashmir.data
  (:require [yesql.core :refer [defqueries]]
            [clojure.java.jdbc :as jdbc]))

(def db-spec {:classname "org.postgresql.Driver"
              :subprotocol "postgresql"
              :subname "//localhost:5432/kashmir"
              :user "kashmir_user"
              :password "password1"})

(defqueries "kashmir/sql/data.sql"
            {:connection db-spec})
