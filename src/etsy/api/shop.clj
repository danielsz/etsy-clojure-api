(ns etsy.api.shop
  (:require [etsy.client :refer [api-call]]))

;; http://www.etsy.com/developers/documentation/reference/shop

(defn find-all-shops 
  "Finds all Shops. If there is a keywords parameter, finds shops with shop_name starting with keywords."
  [& {:keys [shop-name limit offset page lat lon distance-max] :as params}]
  (api-call :GET "/shops" :params params))

(defn get-shop 
  "Retrieves a Shop by id."
  [shop-id]
  (api-call :GET (str "/shops/" shop-id)))

(defn update-shop 
  "Updates a Shop"
  [shop-id & {:keys [title announcement sale_message policy_welcome policy_payment policy_shipping policy_refunds policy_additional policy_seller_info digital_sale_message] :as args}]
  (api-call :PUT "/shops/:shop_id" :params params))

(defn upload-shop-banner 
  "Upload a new shop banner image"
  [shop-id img]
  (api-call :POST "/shops/:shop_id/appearance/banner"))

(defn delete-shop-banner 
  "Deletes a shop banner image"
  [shop-id]
  (api-call :DELETE "/shops/:shop_id/appearance/banner"))

(defn get-listing-shop 
  "Retrieves a shop by a listing id."
  [listing-id]
  (api-call :GET "/shops/listing/:listing_id"))

(defn find-all-user-shops 
  "Retrieves a set of Shop objects associated to a User."
  [user_id & {:keys [limit offset page] :as params}]
  (api-call :GET "/users/:user_id/shops" :params params))
