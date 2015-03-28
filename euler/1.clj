
;; Problem 1
;;   Multiples of 3 and 5

;; If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
;; Find the sum of all the multiples of 3 or 5 below 1000.


(defn sum-multiples
  [nums top]
  (loop [i   1
         sum 0]
    (if (>= i top)
      sum
      (recur
        (inc i)
        (if (some (fn [x] (= 0 (mod i x))) nums)
          (+ sum i)
          sum)))))
(sum-multiples [3 5] 10)



(defn sum-multiples-2
  [nums top]
  (let [multiple? (fn [i x] (= 0 (mod i x)))
        add (fn [sum x] (+ sum (if (some #(multiple? x %) nums) x 0)))]
    (reduce add 0 (range top))))
(sum-multiples-2 [3 5] 10)



(defn multiple?
  [nums x]
  (some #(= 0 (mod x %)) nums))
(defn sum-multiples-3
  [nums top]
  (->> (range)
       (take top)
       (filter #(multiple? nums %))
       (reduce + 0)))
(sum-multiples-3 [3 5] 10)




(map
  #(time (% [3 5] 1000))
  [sum-multiples
   sum-multiples-2
   sum-multiples-3])
;; "Elapsed time: 1.826 msecs"
;; "Elapsed time: 1.323 msecs"
;; "Elapsed time: 3.871 msecs"
;; (233168 233168 233168)


;; Curiously my first solution is the fastest.
;; If I repeatedly execute it, the JVM heats up, but the order of the
;; speed remains constant.


