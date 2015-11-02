(defproject kashmir "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [yesql "0.5.1"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [cheshire "5.5.0"]
                 [com.googlecode.log4jdbc/log4jdbc "1.2"]]
  :clj-sql-up {:database "jdbc:postgresql://kashmir_user:password@localhost:5432/kashmir"
               :deps [[org.postgresql/postgresql "9.4-1201-jdbc41"]]}
  :ring {:handler kashmir.handler/app}
  :resource-paths ["lib/slf4j-simple-1.7.12.jar"]
  :plugins  [[clj-sql-up "0.3.7"]
             [lein-ring "0.9.7"]]
  :main ^:skip-aot kashmir.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}})
