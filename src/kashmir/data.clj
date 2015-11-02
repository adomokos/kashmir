(ns kashmir.data
  (:require [yesql.core :refer [defqueries]]
            [clojure.java.jdbc :as jdbc]))

(def db-spec {:classname "net.sf.log4jdbc.DriverSpy"
              ;:subprotocol "log4jdbc:postgresql"
              :subprotocol "postgresql"
              :subname "//localhost:5432/kashmir"
              :user "kashmir_user"
              :password "password1"})

(defqueries "kashmir/sql/data.sql"
            {:connection db-spec})

(defn find-member [id]
  (find-member-by-id {:id id}))

(defn find-band-by-name [name]
  (first (find-band-by-name-raw {:name name})))

(defn create-member!
  ([member band-name]
    (jdbc/with-db-transaction [tx db-spec]
      (create-member! member band-name tx)))
  ([member band-name tx]
    (let [band-id (:id (find-band-by-name band-name))]
        (create-member-raw! (conj member {:band_id band-id}) {:connection tx}))))
