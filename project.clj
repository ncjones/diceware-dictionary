(defproject diceware-dictionary "0.1.0-SNAPSHOT"
  :description "Generate dictionaries of Diceware passphrases"
  :url "https://github.com/ncjones/diceware-dictionary"
  :license {:name "GNU General Public License"
            :url "https://www.gnu.org/licenses/gpl.html"}
  :dependencies
      [[org.clojure/clojure "1.5.1"]
       [clj-http "1.1.2"]]
  :main ^:skip-aot diceware-dictionary.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
