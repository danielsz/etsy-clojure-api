(ns etsy.client
  (:require 
   [clj-http.client :as client]
   [etsy.core :refer [consumer *oauth-token* *oauth-secret*]]
   [oauth.client :as oauth]
   [clojure.data.json :as json]
   [clojure.tools.logging :as log]))

(def base-url "https://openapi.etsy.com/v2")

(defn sign [method uri params]
  (if (bound? #'*oauth-token* #'*oauth-secret*)
    (let [consumer (oauth/make-consumer 
                    (:key @consumer) 
                    (:secret @consumer) 
                    "https://openapi.etsy.com/v2/oauth/request_token"
                    "https://openapi.etsy.com/v2/oauth/access_token"
                    "https://openapi.etsy.com/v2/oauth/authorize"
                    :hmac-sha1)]
      (oauth/credentials consumer *oauth-token* *oauth-secret* method uri params))
    {:api_key (:key @consumer)}))

(defn api-call
  [method path & {:keys [params payload]}]
  (when-not (seq @consumer) 
    (throw (Throwable. "You must create a consumer first (Etsy API key + secret).")))
  (let [uri (str base-url path)
        options {:query-params (merge params (sign method uri params))}]
    (case method
      :GET (let [usage (fn [limit remaining] (* (/ (- limit remaining) limit) 100)) ; in percent
                 response (client/get uri options)
                 headers (:headers response)
                 limit  (Long/valueOf (get headers "X-RateLimit-Limit"))
                 remaining (Long/valueOf (get headers "X-RateLimit-Remaining"))
                 _ (when (> (usage limit remaining) 90) (log/warn "Exhausting maximum allowed requests per 24 hour" limit remaining))]
             (-> response
                 :body
                 (json/read-str :key-fn keyword)))
      :POST
      :PUT
      :DELETE)))
