(ns shoes.db.data
    (:require [clojure.string :as string]
              [precept.util :as util]))


(def data {:adjective ["Small" "Ergonomic" "Rustic" "Intelligent" "Gorgeous" "Incredible" "Fantastic"
                       "Practical" "Sleek" "Awesome" "Generic" "Handcrafted" "Handmade" "Licensed"
                       "Refined" "Unbranded"]
           :material  ["Steel" "Wooden" "Concrete" "Plastic" "Cotton" "Granite" "Rubber" "Metal"
                       "Soft" "Fresh" "Frozen"]
           :color ["Red" "Orange" "Yellow" "Green" "Blue" "Indigo" "Violet"]
           :product   ["Flats" "Heels" "Sneakers" "Pumps" "Kicks"]})

(def categories ["Casual" "Dress" "Business" "Costume"])


(defn mk-product []
  (let [adj (rand-nth (:adjective data))
        material (rand-nth (:material data))
        color (rand-nth (:color data))
        product (rand-nth (:product data))]
    {:db/id (java.util.UUID/randomUUID)
     :product/name (str adj " " material " " color " " product )
     :product/category (rand-nth categories)
     :product/color color
     :product/img (str product ".jpg")
     :product/price (str (format "%.2f" (rand 100)))}))
