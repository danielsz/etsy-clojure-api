(defproject etsy "0.0.1"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "https://github.com/danielsz/etsy-clojure-api"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "0.7.9"]
                 [clj-oauth "1.4.1"]
                 [org.clojure/data.json "0.2.4"]]
  :repositories [["releases" {:url "https://clojars.org/" :creds :gpg}]]
  :scm {:name "git"
         :url "https://github.com/danielsz/etsy-clojure-api"}
  :main ^:skip-aot etsy.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
