# overtone-loops

An attempt to make a really simple loop syntax for Overtone. Maybe this will be simple enough to use with students at code clubs?

Currently this work is highly experimental. Feel free to leave suggestions on the Issues page.

For example:

```
;; Both are 4 beats to the bar

(defloop0 heart 4
  0 kick
  1 kick)

(defloop0 ticks 4
  0 hat
  1 hat
  2 hat
  3 hat)

(metro-bpm metro 240)
(heart (metro))
(ticks (metro))
```

Often you'll want to pass options to each intrument, e.g. the note to play, or the amplitude or velocity, in which case use `defloop2`:

```
(defloop piano-notes 6
  0 (piano (note :c3))
  2 (piano (note :e3))
  3 (piano (note :g3))
  5 (piano (note :b3))
  )

(defloop piano-louder 6
  0 (piano :vel 50)
  1.5 (piano :vel 70)
  3.5 (piano :vel 80)
  4 (piano :vel 100)
)

(piano-louder (metro))
(piano-notes (metro) 2) ;; play for 2 bars
```

## Usage

See examples in `src/overtone-loops/examples`

TBC


## License

Copyright © 2018 Eric Clack

Distributed under the GNU General Public License v3.0
