(ns uusi.db.database
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import [com.mongodb MongoOptions ServerAddress]))

;;(let [conn (mg/connect {:host "db.megacorp.internal" :port 7878})])

(def dburi "ec2-52-51-164-139.eu-west-1.compute.amazonaws.com")

(defn add-message [message]
    (let [conn (mg/connect {:host dburi :port 27017})
        db (mg/get-db conn "uusi")]
  ;;(mc/insert db "messages" message)
  (mc/save-and-return db "messages" (seq message))))

(defn get-messages []
    (let [conn (mg/connect {:host dburi :port 27017})
          db   (mg/get-db conn "uusi")
          coll "messages"]
      (map #(dissoc % :_id) (mc/find-maps db coll))))