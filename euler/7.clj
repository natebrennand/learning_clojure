
; Problem 7
;   10001st prime
; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
; What is the 10 001st prime number?


(defn divisible?
  [n nums]
  (some #(= 0 (mod n %)) nums))


(defn primes
  [n]
  (loop [i 6
         p [2 3 5]]
    (if (= n (.length p))
      (dec i)
      (recur (inc i) (if (divisible? i p)
                       p
                       (conj p i))))))

(primes 10001)
; 104743



