# overtone-loops

An attempt to make a really simple loop syntax for Overtone.

For example:

```
;; Both are 4 beats to the bar

(defloop heart 4
  0 kick
  1 kick)

(defloop ticks 4
  0 hat
  1 hat
  2 hat
  3 hat)

(metro-bpm metro 240)
(heart (metro))
(ticks (metro))
```

## Usage

See examples in `src/overtone-loops`

TBC


## License

Copyright © 2018 Eric Clack

Distributed under the GNU General Public License v3.0
