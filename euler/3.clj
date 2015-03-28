
;; Problem 3
;;   Largest prime factor

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?



(use 'clojure.algo.generic.math-functions)

;; searches from the top downwards
(defn largest-factor-1
  [n]
  (loop [i (long (/ n 2))]
    (if (> i 1)
      (if (= 0 (mod n i))
        (largest-factor-1 i)
        (recur (dec i)))
      n)))

(largest-factor-1 10)
(largest-factor-1 13195)
;; (largest-factor-1 600851475143)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



(defn divisible?
  [n d]
  (= 0 (mod n d)))
(defn largest-factor-2
  [n]
  (loop [i  2
         lg 1
         n2 n]
    (if (> i n2)
      lg
      (if (divisible? n2 i)
        (recur 2 (max lg i) (/ n2 i))
        (recur (inc i) lg n2)))))



(largest-factor-2 10)
(time (largest-factor-2 13195))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn divisible?
  "divisible determines if a number is divisble by another"
  [n d]
  (= 0 (mod n d)))
(defn minimize
  "minimize divides n by d as long as it is still divisible"
  [n d]
  (loop [n n]
    (if (divisible? n d)
      (recur (/ n d))
      n)))
(defn largest-factor-3
  [n]
  (loop [i  2
         lg 1
         n2 n]
    (if (> i n2)
      lg
      (if (divisible? n2 i)
        (recur (max lg i) (max lg i) (minimize n2 i))
        (recur (inc i) lg n2)))))
(largest-factor-3 10)
(largest-factor-3 13195)
(largest-factor-3 600851475143)
;; 6857






(do
  (time (largest-factor-1 13195))
  (time (largest-factor-2 13195))
  (time (largest-factor-3 13195)))


(do
  (time (largest-factor-2 600851475143))
  (time (largest-factor-3 600851475143)))
