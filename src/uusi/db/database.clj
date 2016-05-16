(ns uusi.db.database
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import [com.mongodb MongoOptions ServerAddress]))

(defn add-message [message]
(let [conn (mg/connect)
      db   (mg/get-db conn "uusi")]
  (mc/insert db "messages" message)))