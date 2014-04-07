(ns etsy.api.user
  (:require [etsy.client :refer [api-call]]))

;; https://www.etsy.com/developers/documentation/reference/user

(defn find-all-users 
  "Finds all Users whose name or username match the keywords parameter."
  [& {:keys [keywords limit offset page] :as params}]
  (api-call :GET "/users" :params params))

(defn get-user
  "Retrieves a User by id. Use __SELF__ to retrieve the user associated with the OAuth credentials"
  [user-id]
  (api-call :GET (str "/users/" user-id)))

