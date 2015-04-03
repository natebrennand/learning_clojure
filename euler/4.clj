
;; Problem 4
;;   Largest palindrome product

;; A palindromic number reads the same both ways.
;; The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
;; Find the largest palindrome made from the product of two 3-digit numbers.


(.length "test")
(.substring "test" 2)
(clojure.string/reverse "test")



(use 'clojure.algo.generic.math-functions)



(defn is-palimdrome?
  [x]
  (let [x (str x)
        n (/ (.length x) 2)
        a (.substring x 0 (ceil n))
        b (clojure.string/reverse (.substring x (floor n)))]
    (= a b)))
(is-palimdrome? "abcde")
(is-palimdrome? "abcba")
(is-palimdrome? "9009")



(defn largest-palimdrome
  "finds the largest palimdromes made multiplying by n-digit numbers."
  [n]
  (loop [m 0
         a n
         b n]
    (cond
      (= a b (- n 100)) m
      (= b (- n 100)) (recur
                  (max m (if (is-palimdrome? (* a b)) (* a b) m))
                  (dec a)
                  n)
      :else (recur
                  (max m (if (is-palimdrome? (* a b)) (* a b) m))
                  a
                  (dec b)))))
(largest-palimdrome 999)



