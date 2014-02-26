(ns etsy.client
  (:require 
   [clj-http.client :as client]
   [etsy.core :refer [consumer *oauth-token* *oauth-secret*]]
   [oauth.client :as oauth]
   [clojure.data.json :as json]))

(def base-url "https://openapi.etsy.com/v2")

(defn sign [method path]
  (if (bound? #'*oauth-token* #'*oauth-secret*)
    (let [consumer (oauth/make-consumer 
                    (:key @consumer) 
                    (:secret @consumer) 
                    "https://api.twitter.com/oauth/request_token" 
                    "https://api.twitter.com/oauth/access_token"                                       
                    "https://api.twitter.com/oauth/authorize" 
                    :hmac-sha1)]
      (oauth/credentials consumer *oauth-token* *oauth-secret* method (str base-url path))) 
    {:api_key (:key @consumer)}))

(defn api-call [method path]
  (when-not (seq @consumer) 
    (throw (Throwable. "You must create a consumer first (Etsy API key + secret).")))
  (case method
    :GET (let [options {:query-params (sign method path)}
               results (client/get (str base-url path) options)]
           (json/read-str (:body results)))
    :POST
    :PUT
    :DELETE))

(defn- build-url [method params])


