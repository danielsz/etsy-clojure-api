(defproject org.danielsz/etsy "0.1.3-SNAPSHOT"
  :description "Etsy API library for Clojure"
  :url "https://github.com/danielsz/etsy-clojure-api"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.3.0"]
                 [clj-oauth "1.5.5"]
                 [org.clojure/data.json "0.2.6"]
                 [environ "1.1.0"]
                 [org.clojure/tools.logging "0.3.1"]]
  :repositories [["releases" {:url "https://clojars.org/" :creds :gpg}]
                 ["snapshots" {:url "https://clojars.org/" :creds :gpg}]]
  :scm {:name "git"
        :url "https://github.com/danielsz/etsy-clojure-api"}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
