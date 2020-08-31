(ns etsy.core
  (:require [sada-abe.constant-rate-alt :refer [throttle-fn]]))

(def consumer (atom {}))

(def ^:dynamic *oauth-token*) 
(def ^:dynamic *oauth-secret*)

(defn make-consumer [key secret]
  (reset! consumer {:key key :secret secret}))

(defn make-client
  ([consumer-key consumer-secret]
   (make-consumer consumer-key consumer-secret)
   (fn [f & args] (apply f args)))
  ([consumer-key consumer-secret throttle-rate]
   (make-consumer consumer-key consumer-secret)
   (fn [f & args] (let [f* (throttle-fn f throttle-rate :second)]
                    (apply f* args)))))

(defmacro with-user
  "Sets the user OAuth access token for write access and for accessing private user data."
  [oauth-token oauth-secret & body]
  `(binding [*oauth-token* ~oauth-token
             *oauth-secret* ~oauth-secret]
     (do
       ~@body)))






