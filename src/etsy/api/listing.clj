(ns etsy.api.listing
  (:require [etsy.client :refer [api-call]]))

(defn find-all-shop-listings-active 
  "Finds all active Listings associated with a Shop."
  [shop-id & {:keys [limit offset page keywords sort_on sort_order min_price max_price color color_accuracy tags category translate_keywords include_private] :as query-params}]
  (api-call :GET (str "/shops/" shop-id "/listings/active") :query-params query-params))
