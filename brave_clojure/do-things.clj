
(println 1/5 2/3 "ratios are cool")

(def name "Chewbacca")
(println
  (str "\"Uggllglglgllglglglgl\" -" name))


{}
{:a 1
 :b "boring example"
 :c []}
{"string key" +}
{:name {:first "Nate" :last "Brennand"}}
(let [x {:name {:first "Nate" :last "Brennand"}}]
  (println (get (get x :name) :first)))

;; nested!
(let [x {:name {:first "Nate" :last "Brennand"}}]
  (println (get-in x [:name :first])))




;; keywords
(:a {:a 1 :b 3})
(:d {:a 1 :b 3} "default")


(hash-map :a 1 :b 2)




;; vectors
[3 2 1]
(get [3 2 1] 1)
(get [:a {:name "turing"} "c"] 1)
(vector 1 2 3 4)
(conj [1 2 3] 4)
(conj [1 2 3] 4 5 6)
(conj [1 2 3] [4 5] 6)



;; lists
'(1 2 3 4 5)
(get '(1 2 3 4 5) 0)
(nth '(1 2 3 4 5) 0)
(list 1 2 3 4 5)
(conj '(1 2 3) 4)

