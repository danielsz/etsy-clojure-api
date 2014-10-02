(defproject org.danielsz/etsy "0.1.3-SNAPSHOT"
  :description "Etsy API library for Clojure"
  :url "https://github.com/danielsz/etsy-clojure-api"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "1.0.0"]
                 [clj-oauth "1.5.1"]
                 [org.clojure/data.json "0.2.5"]]
  :repositories [["releases" {:url "https://clojars.org/" :creds :gpg}]
                 ["snapshots" {:url "https://clojars.org/" :creds :gpg}]]
  :scm {:name "git"
        :url "https://github.com/danielsz/etsy-clojure-api"}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
