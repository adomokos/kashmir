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

(defn find-member [id]
  (find-member-by-id {:id id}))

(defn create-member!
  ([member band-name]
    (jdbc/with-db-transaction [tx db-spec]
      (create-member! member band-name tx)))
  ([member band-name tx]
    (let [band-id (-> (find-band-by-name {:name band-name})
                       first
                       :id)]
        (create-member-raw! (conj member {:band_id band-id}) {:connection tx}))))
