(ns uusi.core
  (:gen-class)
  (:require [uusi.db.database :as db]
            [luminus.repl-server :as repl]
            [luminus.http-server :as http]
            [luminus-migrations.core :as migrations]
            [clojure.tools.cli :refer [parse-opts]]
            [clojure.tools.logging :as log]
            [luminus.logger :as logger]
            [mount.core :as mount]
            [ring.adapter.jetty :as jetty]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (db/add-message {:guest "Ansku" :message "buu"})
  (println "Hello, World!"))
