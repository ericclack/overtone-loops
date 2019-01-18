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
(defloop hats   8 hat   [- 5 - 5 - 5 - 5])
(defloop kicks  8 kick  [7 - 2 - 7 6 2 -])
(defloop claps  4 clap  [- - 1 -])
```

Here the parameters to `defloop` are `loop-name`, `beats-in-a-phrase` the instrument to play, and a list of amplitudes to pass to the instrument on each beat, where `-` is equivalent to `0` and is a muted beat. For ease of typing the scale of amplitudes are 0 (silence) - 9 (full), these are converted to a number between 0 and 1, which is what the instrument expects. 

A variation of this list form is to supply a pair of `(beats  fraction)` so that you can, for example, make a loop with 4 beats to the bar and amplitudes for each 1/2 beat, like this:

```
;;                         beat 1  &   2  &   3  &   4  &
(defloop hats   (4 1/2) hat    [-  5   -  5   -  5   -  5 ]) ;; half beats
(defloop kicks  (4 1/2) kick   [7  -   2  -   7  6   2  - ]) ;; half beats
(defloop claps   4      clap   [-      -      7      -    ]) ;; regular beats
(defloop bells  (4 1/3) bell   [4 - -  - - 4  - 6 -  - 5 7]) ;; triplets
```

## Usage

See code in [examples](src/overtone_loops/examples) or [music](src/overtone_loops/music).

TBC


## License

Copyright © 2018-2019 Eric Clack

Distributed under the GNU General Public License v3.0
