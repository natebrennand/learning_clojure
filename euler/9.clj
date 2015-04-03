
; Problem 9
;   Special Pythagorean triplet
; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;
; a2 + b2 = c2
; For example, 32 + 42 = 9 + 16 = 25 = 52.
;
; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.


(use 'clojure.algo.generic.math-functions)

(defn triplet?
  [a b c]
  (and (< a b c)
       (= (* c c)
         (+ (* a a ) (* b b)))))

(assert (triplet? 3 4 5))
(assert (not (triplet? 3 5 4)))
(assert (not (triplet? 4 3 5)))



(defn find-triplet
  [max-num]
  (for [a (range 1 max-num)
        b (range 1 max-num)
        c (range 1 max-num)
        :when (and (triplet? a b c)
                   (= max-num (+ a b c)))]
    [a b c]))


(find-triplet 1000)
; 200 375 425





