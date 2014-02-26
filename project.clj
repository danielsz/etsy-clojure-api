(defproject etsy "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "0.7.9"]
                 [clj-oauth "1.4.1"]
                 [org.clojure/data.json "0.2.4"]]
  :main ^:skip-aot etsy.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
