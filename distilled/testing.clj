
(defn print-args [& args]
  println args)

(let [{foo :foo bar :bar} {:foo "foo" :bar "bar"}]
  (println foo bar))

(let [{[a b c] :items id :id}{:id "foo" :items [1 2 3]}]
  (println id "->" a b c))

(defn login [{:keys [user pass]}]
  (and (= user "bob")
       (= pass "secret")))

(login {:user "bob" :pass "secret"})

(defn register [{:keys [id pass repeat-pass] :as user}]
  (cond
    (nil? id) "user ID is required"
    (not= pass repeat-pass) "re-entered password doesn't match"
    :else user))


(let [[smaller bigger] (split-with even? (range 10))]
  (println smaller bigger))


(let [state (map even? (range 10))]
  (println state))


(ns colors)
(defn hex->rgb [[_ & rgb]]
  (map #(->> % (apply str "0x") (Long/decode))
       (partition 2 rgb)))
(defn hex-str [n]
  (-> (format "%2s" (Integer/toString n 16))
      (clojure.string/replace " " "0")))
(defn rgb-hex [color]
  (apply str "#" (map hex-str color)))




(declare ^{:dynamic true} *foo* )
(defn with-foo [f]
  (binding [*foo* "I exist!"]
    (f)))
(with-foo #(println *foo*))




(ns shapes)
(defmulti area :shape)
(defmethod area :circle [{:keys [r]}]
  (* Math/PI r r))
(defmethod area :rectangle [{:keys [l w]}]
  (* l w))
(defmethod area :default [shape]
  (throw (Exception. (str "unrecognized shape: " shape))))
(area {:shape :circle :r 10})
(area {:shape :rectangle :l 5 :w 10})


(defmulti fib
  (fn [n] [int]))
(defmethod fib [0] [n] 1)
(fib 0)
(defmethod fib [1] (1))
(defmethod fib [n]
  (+ (fib (- n 1)) (fib (- n 1)) ))




(defprotocol Foo
  "foo docstring"
  (bar [this b] "bar doc string")
  (baz [this] [this b] "baz doc string"))

(deftype Bar [data] Foo
  (bar [this param]
    (println data param))
  (baz [this]
    (println (class this)))
  (baz [this param]
    (println param)))

(let [b (Bar. "some data 123")]
  (.bar b "param")
  (.baz b)
  (.baz b "baz with param"))


(extend-protocol Foo String
  (bar [this param]
    (println this param)))
(bar "hello" "world")
(bar 2 "world")
(bar "hello" 0)




(def global-val (atom nil))
(println (deref global-val))
(println @global-val)

(reset! global-val 10)
(println @global-val)

(swap! global-val inc)
(println @global-val)





(def names (ref []))
(dosync
  (ref-set names ["John"])
  (alter names #(if (not-empty %)
                  (conj % "Jane") %)))



;; tedious replacable function
(def session (atom {:user "Bob"}))
(defn load-content []
  (if (:user @session)
    "Welcome back!"
    "please log in"))

;; macro replacement
(defmacro defprivate [name args & body]
  `(defn ~(symbol name) ~args
     (if (:user @session)
       (do ~@body)
       "please log in")))

(macroexpand-1 '(defprivate foo [greeting] (println greeting)))
(defprivate foo []
  (println "hi!"))




;; calling out to Java examples
(ns java-example
  (:import java.io.File))
(let [f (new File ".")]
  (println (.getAbsolutePath f)))
(.getBytes (.getAbsolutePath (File. ".")))
(.. (File. ".") getAbsolutePath getBytes)


