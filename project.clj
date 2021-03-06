(defproject agile-backend "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
            :min-lein-version "2.0.0"
            :dependencies [[org.clojure/clojure "1.8.0"]
                           [org.clojure/data.json "0.2.6"]
                           [compojure "1.6.1"]
                           [hiccup "1.0.5"]
                           [org.postgresql/postgresql "42.2.5"]
                           [org.clojure/java.jdbc "0.7.0"]
                           [lib-noir "0.9.9"]
                           [clj-time "0.14.0"]
                           [migratus "0.9.8"]
                           [prone "1.1.4"]
                           [ring/ring-anti-forgery "1.1.0"]
                           [ring/ring-defaults "0.3.1"]
                           [ring/ring-json "0.1.2"]
                           [clj-json "0.2.0"]]
                          
            :plugins [[lein-ring "0.9.2"]
                      [lein-ancient "0.6.10"]
                      [migratus-lein "0.5.0"]]
            :migratus {:store :database
                       :migration-dir "migrations"
                       :db  {:subprotocol "postgresql" 
                       :subname "//localhost:5434/agile_backend?charSet=UTF8" 
                       :user "admin" 
                       :password "pass"}}
            :ring {:handler agile_backend.handler/app
                   :init agile_backend.handler/init}
            :profiles
            {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [kerodon "0.8.0"]
                                  [ring/ring-mock "0.3.1"]]
                   :ring {:stacktrace-middleware prone.middleware/wrap-exceptions}}})
