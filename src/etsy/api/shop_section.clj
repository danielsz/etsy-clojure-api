(ns etsy.api.shop-section
  (:require [etsy.client :refer [api-call]]))

;; https://www.etsy.com/developers/documentation/reference/shopsection

(defn find-all-shop-sections [shop-id]
  "Retrieves a set of ShopSection objects associated to a Shop."
  (api-call :GET (str "/shops/" shop-id "/sections")))


