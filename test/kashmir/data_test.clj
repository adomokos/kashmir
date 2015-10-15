(ns kashmir.data-test
  (:require [clojure.test :refer :all]
            [kashmir.data :refer :all]
            [clojure.java.jdbc :as jdbc]))

(deftest count-members-test
  (testing "there are 4 members"
    (is (= 4 (-> (count-members) first :count)))))

(deftest find-member-by-id-test
  (testing "finds PM with id 2"
    (is (= "Paul" (-> (find-member 2) first :first_name)))))

(deftest create-member-test
  (jdbc/with-db-transaction [tx db-spec]
    (jdbc/db-set-rollback-only! tx)
      (testing "adds a member to the DB"
        (let [member {:first_name "Jim" :last_name "Morrison" :email "jmorrison@doors.com"}]
          (is (= 1 (create-member! member "The Doors" tx)))))))
