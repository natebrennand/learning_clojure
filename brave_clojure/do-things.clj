
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



;; sets
#{"hannah montana" "mily cyrus" 20 45}
(conj #{:a :b} :b)
(conj #{:a :b} #{:b})
(get #{:a :b} :a)
(get #{:a :b} :c)
(:a #{:a :b})
(:c #{:a :b})
(get #{:a :b} "hannah montana")

(set [1 2 3 3 3 3 3 3 3 2])
(get (set [3 3 3 3 3 4 4]) 3)
(get (set [3 3 3 3 3 4 4]) 5)

(hash-set 1 1 1 1 3 1 2)
(sorted-set :b :a :c)



;; symbols & naming
(def failed-movie-titles ["gone with the moving air" "Swellfellas"])
(identity 'test)
(identity 'failed-movie-titles)
(first failed-movie-titles)

(eval failed-movie-titles)
(first '(failed-movie-titles 0 1))
(second '(failed-movie-titles 0 1))
(second '(failed-movie-titles))





;; functions
(+ 1 2 3 4)
(* 1 2 3 4)
(first [1 2 3 4])

(or + -)
((or + -) 1 2 3 4)

((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)

(1 2 3 4)
("test" 1 2 3)

(inc 1.1)
(map inc [0 1 2 3])
(map inc #{0 1 2 3})
(set (map inc [0 1 2 3]))

(+ (inc 199) (/ 100 (- 7 2)))


;; defining functions
(defn too-enthusiastic
  "return a cheer that might be a bit too enthusiastic"
  [name]
  (str "Oh. my. god. " name " you're the best"))
(too-enthusiastic "zelda")


;; parameters
(defn no-params
  []
  "i have no params")
(defn one-param
  [x]
  (str "i take one param: " x))
(defn one-param
  [x y]
  (str "i take two params: " x y))

;; overloading through parameter arity
(defn multi-arity
  ([first-arg second-arg third-arg]
   (str "3: " first-arg second-arg third-arg))
  ([first-arg second-arg]
   (str "2: " first-arg second-arg))
  ([first-arg]
   (str "1: " first-arg)))
(multi-arity 1 2 3)
(multi-arity 1 3)


(defn x-chop
  "describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! take that!"))
  ([name]
   (x-chop name "karate")))
(x-chop "kanye" "slap")
(x-chop "kanye")

;; bad arity solution
(defn weird-arity
  ([]
   "destiny")
  ([number]
   (inc number)))
(weird-arity 3)
(weird-arity)









