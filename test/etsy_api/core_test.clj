(ns etsy-api.core-test
  (:require [clojure.test :refer :all]
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

(def client (make-client (System/getProperty "consumer.token") (System/getProperty "consumer.secret")))
(def token (System/getProperty "user.token"))
(def secret (System/getProperty "user.secret"))

(with-user token secret
  (client shop/find-all-user-shops (System/getProperty "shop.id")))
