(ns reducate.test.core
  (:use [reducate.core] :reload)
  (:use [clojure.test]))

(def words [["delicious" "coffee"]
            ["scrumptious" "scones"]
            ["hungry" "hackers"]])

(deftest test-reducate-three-arg
  (is (= 12 (reducate [acc 0]
                      [n [1 2 3]]
                      (+ acc (* n 2)))))
  (is (= {:sea :jure, :zoka :coffee}
         (reducate [acc {}]
                   [pair [[:sea :jure] [:zoka :coffee]]]
                   (conj acc pair))))
  (is (= " delicious scrumptious hungry"
         (reducate [acc ""]
                   [[adj noun] words]
                   (str acc " " adj)))))

;; Case 1
;; (reducate [foo bar] (do-something foo bar))
;; (reducate [accum 0] [foo [:bar] x [:y]]  (do-something))

(deftest test-reducate-two-arg
  (is (= 12 (reducate [n [0 1 2 3]]
                      (+ % (* n 2))))))
