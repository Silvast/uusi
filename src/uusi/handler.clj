(ns uusi.handler
  (:require [compojure.api.sweet :refer :all]
            [ring.util.http-response :refer :all]
            [schema.core :as s]
            [uusi.db.database :as db]))

(s/defschema Pizza
  {:name s/Str
   (s/optional-key :description) s/Str
   :size (s/enum :L :M :S)
   :origin {:country (s/enum :FI :PO)
            :city s/Str}})

(def app
  (api
    {:swagger
     {:ui "/"
      :spec "/swagger.json"
      :data {:info {:title "Simple"
                    :description "Compojure Api example"}
             :tags [{:name "api", :description "some apis"}]}}}

    (context "/api" []
             :tags ["api"]

             (GET "/plus" []
                  :return {:result Long}
                  :query-params [x :- Long, y :- Long]
                  :summary "adds two numbers together"
                  (ok {:result (+ x y)}))

             (POST "/echo" []
                   :return Pizza
                   :body [pizza Pizza]
                   :summary "echoes a Pizza"
                   (ok pizza))

             (POST "/message" request
                   :return      {:guest String :message String}
                   :body-params [guest :- String message :- String]
                   :summary     "add new message"
                   (ok (dissoc (db/add-message {:guest guest
                                        :message message}) :_id)))

             (GET "/messages" []
                  :return       [{:guest String :message String}]
                  :summary      "get messages"
                  (ok (db/get-messages))))))