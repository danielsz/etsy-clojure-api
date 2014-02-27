(ns etsy.client
  (:require 
   [clj-http.client :as client]
   [etsy.core :refer [consumer *oauth-token* *oauth-secret*]]
   [oauth.client :as oauth]
   [clojure.data.json :as json]))

(def base-url "https://openapi.etsy.com/v2")

(defn sign [method uri query-params]
  (if (bound? #'*oauth-token* #'*oauth-secret*)
    (let [consumer (oauth/make-consumer 
                    (:key @consumer) 
                    (:secret @consumer) 
                    "https://api.twitter.com/oauth/request_token" 
                    "https://api.twitter.com/oauth/access_token"                                       
                    "https://api.twitter.com/oauth/authorize" 
                    :hmac-sha1)]
      (oauth/credentials consumer *oauth-token* *oauth-secret* method uri query-params)) 
    {:api_key (:key @consumer)}))

(defn api-call
  [method path & {:keys [params payload]}]
  (when-not (seq @consumer) 
    (throw (Throwable. "You must create a consumer first (Etsy API key + secret).")))
  (let [uri (str base-url path)
        options {:query-params (merge query-params (sign method uri params))}]
    (case method
      :GET (let [results (client/get uri options)]
             (json/read-str (:body results)))
      :POST
      :PUT
      :DELETE)))

(defn- build-url [method params])


