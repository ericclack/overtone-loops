# overtone-loops

An attempt to make a really simple loop syntax for Overtone, to help make drum patterns or other repeating phrases.

Currently this work is highly experimental. Feel free to leave suggestions on the Issues page. I should point out that I'm not a talented drummer!

How do you program loops? First define some samples:

```
(def kick (freesound2 171104))
(def hat (freesound2 404890))
```

Now to define your loop. The simplest method uses `defloop0` to combine beat numbers and samples. The parameters to `defloop0` are `loop-name`, `beats-in-a-phrase` and then pairs of `beat` and `sample` (or any function):

```
(defloop0 heart 4
  0 kick
  1 kick)

(defloop0 ticks 4
  0 hat
  1 hat
  2 hat
  3 hat)

(bpm 240)
(heart (metro))
(ticks (metro))
```

Almost always you'll want to pass options to each intrument, e.g. the note to play, or the amplitude or velocity, in which case use `defloop`:

```
(defloop piano-notes 6
  0 (piano (note :c3))
  2 (piano (note :e3))
  3 (piano (note :g3))
  5 (piano (note :b3))
  )

(defloop piano-louder 6
  0   (piano :vel 50)
  1.5 (piano :vel 70)
  3.5 (piano :vel 80)
  4   (piano :vel 100)
)

(bpm 90)
(piano-louder (metro))
(piano-notes (metro) 2) ;; play for 2 bars
```

Notice that we used fractional beats, that's fine and helps us create off-beats. Also any of the loops accept a number of bars (or really repetitions) to play.

There's one more `defloop` form that's super useful for drum patterns, you can provide a list of amplitudes like this:

```
(defloop hats   8 hat   [0    0.5  0    0.5  0    0.5   0    0.5])
(defloop kicks  8 kick  [0.7  0    0.2  0    0.7  0.6   0.2  0  ])
(defloop claps  4 clap  [0    0    1    0    ])
```

Here the parameters to `defloop` are `loop-name`, `beats-in-a-phrase` the instrument to play, and a list of amplitudes to pass to the instrument on each beat, where `0` is a muted beat.

## Usage

See code in [examples](src/overtone_loops/examples) or [music](src/overtone_loops/music).

TBC


## License

Copyright © 2018-2019 Eric Clack

Distributed under the GNU General Public License v3.0
