
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

;; doesn't compile
(defn match-arity
  ([] "test")
  ([] "test2"))
(match-arity)


(defn codger-communication
  [whippersnapper]
  (str "get off my lawn, " whippersnapper "!!!"))
(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))
(codger "billy" "anne", "hulk")


(defn fav-things
  [name & things]
  (str "hi, " name ", here are a few of my favorite things: " (clojure.string/join ", " things)))
(fav-things "nate" "python" "go" "clojure")



;; destructuring arguments
(defn my-first
  [[first-thing]]
  first-thing)
(my-first ["oven" "bike" "waraxe"]) 
;; vs non-destructuring
(defn other-my-first
  [things]
  (first things))
(other-my-first ["oven" "bike" "waraxe"]) 

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "your 1st choice is: " first-choice))
  (println (str "your 2nd choice is: " second-choice))
  (println (str "we're ignoring the rest of your choices: " (clojure.string/join ", " first-choice))))


;; destructuring maps
(defn announce_treasure_location
  [{lat :lat lng :lng}]
  (println (str "latitude: " lat))
  (println (str "longtitude: " lng)))
(announce_treasure_location {:lat 23 :lng 30})

(defn announce_treasure_location-2
  [{:keys [lat lng]}]
  (println (str "latitude: " lat))
  (println (str "longtitude: " lng)))
(announce_treasure_location-2 {:lat 23 :lng 30})

(defn announce_treasure_location-3
  [{:keys [lat lng] :as treasure-location}]
  (println (str "latitude: " lat))
  (println (str "longtitude: " lng))
  (println (str "treasure at: " treasure-location)))
(announce_treasure_location-3 {:lat 23 :lng 30})


;; function body exploration
(defn illustrative-function
  []
  (+ 1 304)
  30
  "joe")
(illustrative-function)

(defn number-comment
  [x]
  (if (> x 6)
    "ob my gosh, what a large number"
    "that's an OK number I guess"))
(number-comment 4)
(number-comment 8)



;; there are many ways to declare functions
(map (fn [name] (str "Hi, " name))
     ["darth vader" "mr magoo"])
((fn [x] (* 3)) 8)

(def my-special-multiplier (fn [x] (* x 3)))
(my-special-multiplier 12)


;; compact lambdas
#(* % 3)
(#(* % 3) 8)
(map #(str "hi, " %)
     ["darth vader" "mr magoo"])

(def cube #(* % % %))
(cube 3)

(def multiply #(* %1 %2))
(multiply 2 3)


(#(identity %&) 1 "blab" :hi)



;; returning functions
(defn inc-maker
  "creates a custom incrementer"
  [inc-by]
  #(+ inc-by %))
(def inc3 (inc-maker 3))
(inc3 7)




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 4.1 Pulling it all together
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

;; but now we need to create their right side!

;; let examples
(let [[part & remaining] remaining-asym-parts
       final-body-parts (conj final-body-parts part)]
  some-stuff)

(let [x 3]
  x)
(def dalmation-list
  ["pongo" "perdita" "puppy 1" "puppy 2"]) ;; missing 97
(let [dalmations (take 2 dalmation-list)]
      dalmations)


;; let creates a new scope
(def x 0)
(let [x 1] x)
;; however, you can still use the outer scope in your explanation
(def x 0)
(let [x 1] x)

;; rest params are usable in let too
(let [[pongo & dalmations] dalmation-list]
  [pongo dalmations])


(loop [iteration 0]
  (println (str "iteration: " iteration))
  (if (> iteration 3)
    (println "goodbye")
    (recur (inc iteration))))


(defn recursive-printer
  ([] (recursive-printer 0))
  ([iteration]
   (println (str "iteration: " iteration))
   (if (> iteration 3)
     (println "goodbye")
     (recursive-printer (inc iteration)))))
(recursive-printer)




;; start to actually fix the hobbit!
(defn needs-matching-part?
  [part]
  (re-find #"^left-" (:name part)))
;; tests
(needs-matching-part? {:name "left-eye"})
(needs-matching-part? {:name "neckbeard"})

(defn make-matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
;; test
(make-matching-part {:name "left-eye" :size 1})


(defn symmetrize-body-parts
  "expects a sequence of maps with a :name & :size"
  [body-parts]
  (loop [remaining-parts body-parts
         final-body-parts []]
    (if (empty? remaining-parts)
      final-body-parts
      (let [[part & remaining] remaining-parts
            final-body-parts (conj final-body-parts part)]
        (if (needs-matching-part? part)
          (recur remaining (conj final-body-parts (make-matching-part part)))
          (recur remaining final-body-parts))))))
(symmetrize-body-parts asym-hobbit-body-parts)


(defn symmetrize-body-parts-2
  "expects a sequence of maps with a :name & :size"
  [body-parts]
  (loop [remaining-parts body-parts
         final-body-parts []]
    (if (empty? remaining-parts)
      final-body-parts
      (let [[part & remaining] remaining-parts
            final-body-parts (conj final-body-parts part)]
        (recur remaining (if (needs-matching-part? part)
                           (conj final-body-parts (make-matching-part part))
                           (final-body-parts)))))))
(map println (symmetrize-body-parts asym-hobbit-body-parts))


(let [x [1 2 3 4]]
  (conj x nil))




;; shortening things w/ reduce

(reduce + [1 2 3 4 5])
;; analagous to 
(+ (+ (+ (+ 1 2) 3) 4) 5)

;; can also take an initial arg
(reduce + 15  [1 2 3 4 5])


(defn reduce-symmetrize
  [body-parts]
  (reduce (fn [final-body-parts part]
            (let [final-body-parts (conj final-body-parts part)]
              (if (needs-matching-part? part)
                (conj final-body-parts (make-matching-part part))
                final-body-parts)))
          []
          body-parts))
(map println (reduce-symmetrize asym-hobbit-body-parts))




;; now the hobbits are getting into a fight....
(defn hit
  [asym-body-parts]
  (let [sym-parts (reduce-symmetrize asym-body-parts)
        body-part-size-sum (reduce + 0 (map :size sym-parts))
        target (inc (rand body-part-size-sum))]
    (loop [[part & rest] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur rest (+ accumulated-size (:size part)))))))

(hit asym-hobbit-body-parts)






