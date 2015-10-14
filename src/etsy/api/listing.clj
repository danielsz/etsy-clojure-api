(ns etsy.api.listing
  (:require [etsy.client :refer [api-call]]))

;; https://www.etsy.com/developers/documentation/reference/listing

(defn find-all-shop-listings-active 
  "Finds all active Listings associated with a Shop."
  [shop-id & {:keys [limit offset page keywords sort_on sort_order min_price max_price color color_accuracy tags category translate_keywords include_private] :as params}]
  (api-call :GET (str "/shops/" shop-id "/listings/active") :params params))

(defn get-listing
  "Get listing by listing id"
  [listing-id]
  (api-call :GET (str "/listings/" listing-id)))

(defn find-all-shop-section-listings-active
  "Finds all listings within a shop section"
  [shop-id shop_section_id & {:keys [limit offset page sort_on sort_order] :as params}]
  (api-call :GET (str "/shops/" shop-id "/sections/" shop_section_id "/listings/active") :params params))
