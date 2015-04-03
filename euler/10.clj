
; Summation of primes
;   Problem 10
; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;
; Find the sum of all the primes below two million.



(defn divisible?
  [n nums]
  (some #(= 0 (mod n %)) nums))


(defn sum-primes
  [n]
  (loop [i 3
         p [2]
         s 2]
    (if (= n i)
      s
      (if (divisible? i p)
        (recur (inc i)
               p
               s)
        (recur (inc i)
               (conj p i)
               (+ s i))))))



(assert (= 17 (sum-primes 10)))



(sum-primes 1000)

(sum-primes 2000000)
; 142913828922



