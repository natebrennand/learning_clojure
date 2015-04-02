
; Problem 5
;   Smallest multiple
;
;2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?




(defn divisible?
  [n nums]
  (every? #(= 0 (mod n %)) nums))

(divisible? 20 [1 2 4 5])
(divisible? 6 [7 8 9 10])

(divisible? 8 (range (+ 1 8) (+ 1 10)))

(defn reduce-range
  [n]
  (filter
    (fn [x]
      (not-any?
        #(divisible? % [x])
        (range (+ 1 x) (+ 1 n))))
    (range 1 (+ 1 n))))

(reduce-range 4)
(reduce-range 10)



(defn smallest-divisible
  [n]
  (let [nums (reduce-range n)]
    (loop [i n]
      (if (divisible? i nums)
        i
        (recur (+ i n))))))
(smallest-divisible 20)


