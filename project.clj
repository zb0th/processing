(defproject
  processing
  "0.1.0-SNAPSHOT"
  :dependencies
  [[org.clojure/clojure "1.5.1"]
   [lib-noir "0.4.9"]
   [compojure "1.1.5"]
   [ring-server "0.2.7"]
   [com.taoensso/timbre "1.5.2"]
   [com.taoensso/tower "1.2.0"]
   [markdown-clj "0.9.19"]
   [org.clojure/java.jdbc "0.2.3"]
   [com.h2database/h2 "1.3.170"]
   [korma "0.3.0-RC2"]
   [log4j "1.2.15" :exclusions [javax.mail/mail javax.jms/jms com.sun.jdmk/jmxtools com.sun.jmx/jmxri]]
   [clabango "0.5"]
   [crate "0.2.4"]
   [domina "1.0.1" :exclusions [org.clojure/clojure]]
   #_[fetch "0.1.0-alexguev-alpha1"]]
  :ring
  {:handler processing.handler/war-handler,
   :init processing.handler/init,
   :destroy processing.handler/destroy}
  :profiles
  {:production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}},
   :dev
   {:dependencies [[ring-mock "0.1.3"] [ring/ring-devel "1.1.8"]]}}
  :url
  "http://example.com/FIXME"
  :plugins
  [[lein-ring "0.8.3"]
   [lein-cljsbuild "0.3.0"]]
  :description
  "FIXME: write description"
  :min-lein-version "2.0.0"
  :source-paths ["src/clj"]
  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src/cljs"], 
              :compiler {:pretty-print true, 
                         :output-to "resources/public/cljs/main.js",
                         :output-dir "resources/public/cljs/"
                         :optimizations :none}}
             {:id "prod"
              :source-paths ["src/cljs"], 
              :compiler {:output-to "resources/public/cljs/main.js",
                         :optimizations :advanced}}]})


  
