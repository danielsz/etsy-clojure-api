(ns etsy.core)

(def consumer (atom {}))

(def ^:dynamic *oauth-token*) 
(def ^:dynamic *oauth-secret*)

(defn make-consumer [key secret]
  (reset! consumer {:key key :secret secret}))

(defmacro with-auth
  "Sets the user OAuth access token for write access and for accessing private user data."
  [oauth-token oauth-secret & body]
  `(binding [*oauth-token* ~oauth-token
             *oauth-secret* ~oauth-secret]
     (do
       ~@body)))




