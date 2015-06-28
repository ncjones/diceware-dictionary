(ns diceware-dictionary.core
  (:require
    clj-http.client
    [clojure.string :as str]))

(defn get-body [url]
  (:body (clj-http.client/get url)))

(defn get-and-cache [url filename]
  (if (.exists (clojure.java.io/file filename))
    (slurp filename)
    (let [body (get-body url)]
      (spit filename body)
      body)))

(def dice-text
  (get-and-cache
    "http://world.std.com/~reinhold/diceware.wordlist.asc"
    "diceware.wordlist.asc"))

(def dice-text-lines
  (clojure.string/split-lines dice-text))

(def dice-lines
  (filter #(re-matches #"^\d{5}.*" %) dice-text-lines))

(defn second-tsv [s]
  (nth (str/split s #"\t") 1))

(def dice-words
  (map second-tsv dice-lines))

(defn -main [& args]
  (doseq [line dice-words]
    (println line)))
