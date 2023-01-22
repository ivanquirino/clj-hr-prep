(defproject clj-hr-prep "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot clj-hr-prep.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :native-image ;; used by default
             {:jvm-opts ["-Dclojure.compiler.direct-linking=true"]
              :opts ["--report-unsupported-elements-at-runtime"
                     "--initialize-at-build-time"
                     "--verbose"]}
             :test    ;; e.g. lein with-profile +test native-image
             {:native-image {:opts ["--report-unsupported-elements-at-runtime"
                                    "--initialize-at-build-time"
                                    "--verbose"]}}}
  :plugins [[io.taylorwood/lein-native-image "0.3.1"]]
  :native-image {:name "clj-hr-prep"                 ;; name of output image, optional
                 :graal-bin "/home/ivan/.jdks/graalvm-ce-19" ;; path to GraalVM home, optional
                 :opts ["--verbose"]})
