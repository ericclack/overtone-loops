(ns overtone-loops.utils)

(defmacro thunk
  "Wrap the body in a function, thereby delaying execution"
  [& body]
  `(fn [] ~@body))

(defn map-odds
  "Apply fn to odd items only: 1st, 3rd, ..."
  [fn seq]
  (cond
    (empty? seq) '()
    :else (list* (fn (first seq))
                 (second seq)
                 (map-odds fn (rest (rest seq))))))

(defn map-evens
  "Apply fn to even items only: 2nd, 4th, ..."
  [fn seq]
  (cond
    (empty? seq) '()
    :else (list* (first seq)
                 (fn (second seq))
                 (map-evens fn (rest (rest seq))))))

(defn pairer
  "Pair up items from a sequence, e.g. beat playable pairs

  (pairer '(1 2 3 4 5 6 7 8))
  => ((1 2) (3 4) (5 6) (7 8))
  "
  [seq]
  (cond
    (empty? seq) '()
    :else (cons (list (first seq) (second seq))
                (pairer (rest (rest seq))))
    ))

