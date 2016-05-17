(defproject uusi "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.novemberain/monger "3.0.2"]
                 [luminus-log4j "0.1.3"]
                 [metosin/compojure-api "1.1.0"]
                 [selmer "1.0.4"]
                 [markdown-clj "0.9.89"]
                 [ring-middleware-format "0.7.0"]
                 [metosin/ring-http-response "0.6.5"]
                 [metosin/ring-swagger-ui "2.1.4-0"]
                 [bouncer "1.0.0"]
                 [org.clojure/tools.logging "0.3.1"]
                 [compojure "1.5.0"]
                 [ring-webjars "0.1.1"]
                 [ring/ring-defaults "0.2.0"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [mount "0.1.10"]
                 [cprop "0.1.7"]
                 [org.clojure/tools.cli "0.3.4"]
                 [luminus-nrepl "0.1.4"]
                 [luminus-migrations "0.1.2"]
                 [luminus-immutant "0.2.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :main ^:skip-aot uusi.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :ring {:handler uusi.handler/app})
