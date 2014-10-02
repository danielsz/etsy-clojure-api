(ns etsy.api.transaction
  (:require [etsy.client :refer [api-call]]))

;;https://www.etsy.com/developers/documentation/reference/transaction

(defn find-all-shop-transactions
  "Retrieves a set of Transaction objects associated to a Shop."
  [shop-id & {:keys [limit offset page] :as params}]
  (api-call :GET (str "/shops/" shop-id "/transactions") :params params))


