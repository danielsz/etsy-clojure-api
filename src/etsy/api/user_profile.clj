(ns etsy.api.user-profile
  (:require [etsy.client :refer [api-call]]))

;; https://www.etsy.com/developers/documentation/reference/userprofile

(defn find-user-profile
  "Returns the UserProfile object associated with a User."
  [user-id]
  (api-call :GET (str "/users/" user-id "/profile")))
