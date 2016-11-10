(ns etsy-api.core-test
  (:require [clojure.test :refer :all]
            [environ.core :refer [env]]
            [etsy.core :refer [with-user make-client]]
            [etsy.api
             [user :as user]
             [user-profile :refer [find-user-profile]]
             [shop :as shop]
             [listing :as listing]
             [shop-section :as sections]
             [listing-image :as images]]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(def client (make-client (:consumer-token env) (:consumer-secret env)))
(def token (:user-token env))
(def secret (:user-secret env))

(with-user token secret
  (client shop/find-all-user-shops (:shop-id env)))
