(ns etsy.api.listing-image
  (:require [etsy.client :refer [api-call]]))

;; https://www.etsy.com/developers/documentation/reference/listingimage

(defn find-all-listing-images 
  "Retrieves a set of ListingImage objects associated to a Listing."
  [listing-id]  
  (api-call :GET (str "/listings/" listing-id "/images")))

