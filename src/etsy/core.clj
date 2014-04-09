(ns etsy.core
  (:require [etsy.client :refer [api-call api-call2]]))

(def consumer (atom {}))

(def ^:dynamic *oauth-token*) 
(def ^:dynamic *oauth-secret*)

(defn make-consumer [key secret]
  (reset! consumer {:key key :secret secret}))

(defn callfn [f & args] (apply f args))

(defn make-client [consumer-key consumer-secret]
  (make-consumer consumer-key consumer-secret)
  callfn)
  
(defmacro with-user
  "Sets the user OAuth access token for write access and for accessing private user data."
  [oauth-token oauth-secret & body]
  `(binding [*oauth-token* ~oauth-token
             *oauth-secret* ~oauth-secret]
     (do
       ~@body)))






