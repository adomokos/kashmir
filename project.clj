(defproject kashmir "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [yesql "0.5.1"]]
  :main ^:skip-aot kashmir.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :clj-sql-up {:database "jdbc:postgresql://kashmir_user:password@localhost:5432/kashmir"
               :deps [[org.postgresql/postgresql "9.4-1201-jdbc4"]]}
  :plugins  [[clj-sql-up "0.3.7"]])
