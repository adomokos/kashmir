(ns kashmir.data-test
  (:require [clojure.test :refer :all]
            [kashmir.data :refer :all]))

(deftest count-members-test
  (testing "there are 4 members"
    (is (= 4 (-> (count-members) first :count)))))
