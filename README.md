# reducate

reducate is a new fancy shiny reduce-like macro! You'll love it!

## Usage

Ever get tired of function literals in your reduce? When you get tired
of them with map, you can switch to a for macro, but no such luck with
reduce ... until now!

    (def words [["delicious" "coffee"]
                ["scrumptious" "scones"]
                ["hungry" "hackers"]])

    ;; the old way
    (reduce (fn [acc [adj noun]] (conj acc adj)) 
            [] words)
    ;; => ["delicious" "scrumptious" "hungry"]

    ;; but look!
    (reducate [acc []] [[adj noun] words]
      (conj acc adj))
    ;; => ["delicious" "scrumptious" "hungry"]

## License

Copyright (C) 2010 Seajure

Distributed under the Eclipse Public License, the same as Clojure.
