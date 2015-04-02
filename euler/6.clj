

; Problem 6
;   Sum square difference
;
; The sum of the squares of the first ten natural numbers is:
;   1^2 + 2^2 + ... + 10^2 = 385
;
; The square of the sum of the first ten natural numbers is,
;   (1 + 2 + ... + 10)^2 = 552 = 3025
; Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
;
; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.



(defn sum-square-diff
  [n]
  (loop [i 0
         sum 0
         square 0]
    (if (= i (+ n 1))
      (- (* square square) sum)
      (recur
        (+ i 1)
        (+ sum (* i i))
        (+ square i)))))

(sum-square-diff 10)
(sum-square-diff 100)


