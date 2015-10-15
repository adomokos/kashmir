(ns kashmir.logic-test
  (:require [clojure.test :refer :all]
            [kashmir.logic :refer :all]
            [cheshire.core :as json]))

(deftest find-member-by-id-test
  (testing "returns a JSON serialized member record"
      (let [member (first (json/parse-string (find-member 2) true))]
        (is (= "Paul" (:first_name member))))))
