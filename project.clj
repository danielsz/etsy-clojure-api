(defproject etsy "0.0.4"
  :description "Etsy API library for Clojure"
  :url "https://github.com/danielsz/etsy-clojure-api"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "0.7.9"]
                 [clj-oauth "1.4.1"]
                 [org.clojure/data.json "0.2.4"]]
  :repositories [["releases" {:url "https://clojars.org/" :creds :gpg}]]
  :scm {:name "git"
        :url "https://github.com/danielsz/etsy-clojure-api"}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
