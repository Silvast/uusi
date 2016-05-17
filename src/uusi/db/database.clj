(ns uusi.db.database
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import [com.mongodb MongoOptions ServerAddress]))


(defn add-message [message]
    (let [conn (mg/connect)
        db (mg/get-db conn "uusi")]
  ;;(mc/insert db "messages" message)
  (mc/save-and-return db "messages" (seq message))))

(defn get-messages []
    (let [conn (mg/connect)
          db   (mg/get-db conn "uusi")
          coll "messages"]
      (map #(dissoc % :_id) (mc/find-maps db coll))))