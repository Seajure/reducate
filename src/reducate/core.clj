(ns reducate.core)

(defmacro reducate
  "map:for :: reduce:reducate"
  ([accum bindings body]
     `(reduce (fn ~[(first accum) (first bindings)] ~body)
              ~(second accum) ~(second bindings)))
  ([[name value] body]
     `(let [[init# & more#] ~value]
        (reducate [~'% init#] [~name more#] ~body))))
