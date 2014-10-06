(ns etsy.api.receipt
  (:require [etsy.client :refer [api-call]]))

;; https://www.etsy.com/developers/documentation/reference/receipt

(defn get-receipt
  "Retrieves a Receipt by id."
  [receipt-id]
  (api-call :GET (str "/receipt/" receipt-id)))

(defn find-all-shop-receipts-by-status
  "Retrieves a set of Receipt objects associated to a Shop based on the status." 
  [shop-id status & {:keys [limit offset page] :as params}]
  {:pre [(some #{status} '("open" "unshipped" "unpaid" "completed" "processing" "all"))]}
  (api-call :GET (str "/shops/" shop-id "/receipts/" status) :params params))

