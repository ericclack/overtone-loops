# Overtone Loops

A simple, yet flexible, loop syntax for Overtone, to make drum patterns or other repeating phrases.

Currently this work is highly experimental. Feel free to leave suggestions on the Issues page. I should point out that I'm not a talented drummer!

## How do you program loops?

First load in Overtone Live and Loops namespaces `loops` and `samples`:

```
(use 'overtone.live
     'overtone-loops.loops
     'overtone-loops.samples)
```

Then create loops with a list of beats. Each value in the list is an amplitude.

```
;;                         beat   1 2 3 4 5 6 7 8
(defloop hats   8 cymbal-closed  [- 5 - 5 - 5 - 5])
(defloop kicks  8 bass-hard      [7 - 2 - 7 6 2 -])
(defloop claps  4 clap           [- - 4 -])
```

The parameters to `defloop` are `loop-name`, `beats-in-a-phrase`, the instrument to play, and a list of amplitudes to pass to the instrument on each beat, where `-` is equivalent to `0`, a muted beat. For ease of coding the scale of amplitudes are 0 (silence) - 9 (full), these are converted to a number between 0 and 1, which is what the instrument expects. 

To play these loops just call the loop-name function with a timer from `(metro)`, do set the `bpm` first to ensure the correct playback speed.

```
(bpm 200)
(hats (metro))
(kicks (metro))
(crashes (metro))
;; To stop
(stop)
```

Usually you'll want some sort of scheduling, use `at-bar` to set the appropriate time:

```
(beats-in-bar 4)
(at-bar 1 (hats) (kicks))
(at-bar 3 (claps))
```

A variation of this list form is to supply a pair of `(beats fraction)` so that you can, for example, make a loop with 4 beats to the bar and amplitudes for each 1/2 beat, like this:

```
;;                                beat 1  &   2  &   3  &   4  &
(defloop hats   (4 1/2) cymbal-closed [-  5   -  5   -  5   -  5 ]) ;; half beats
(defloop kicks  (4 1/2) bass-hard     [7  -   2  -   7  6   2  - ]) ;; half beats
(defloop claps   4      clap          [-      -      7      -    ]) ;; regular beats
(defloop bells  (4 1/3) cowbell       [- - -  5 - 1  5 1 -  - 1 5]) ;; triplets
```

Then run with:

```
(bpm 120)
(at-bar 1 (hats) (kicks) (claps) (bells))
```

Check out the documentation for `at-bar` and `on-next-bar` to find out more about scheduling. E.g. `(odoc at-bar)`.

## More than amplitude

If you want to send your instrument more than just an amplitude you can use a nested
loop syntax. For example, here's how we can program a note and amplitude with a helper
function:

```
(defn k [anote amp]
  (ks1 (note anote) :amp (/ amp 9)))

(deflooplist melody1 8 k [[:g4 8] [:a4 8] [:b4 8] [:c5 8]])
```

## Beat adjustment

When playing loops you can adjust the timing of certain beats to create a more interesting sound. For example you can play half-beats late to create a shuffle, or add a bit of randomness to make it sound more human. See `examples/beat-adjust.clj` or `music/walk.clj`.

## Alternative loop macros

There are two other ways to program loops. The most basic method uses `defloop0` to combine beat numbers and samples. The parameters to `defloop0` are `loop-name`, `beats-in-a-phrase` and then pairs of `beat` and `sample` (or any function):

```
(defloop0 heart 4
  0 bass-soft
  1 bass-soft)

(defloop0 ticks 4
  0 cymbal-closed
  1 cymbal-closed
  2 cymbal-closed
  3 cymbal-closed)

(bpm 240)
(beats-in-bar 4)
(at-bar 1
        (heart)
        (ticks))
```

Almost always you'll want to pass options to each intrument, e.g. the note to play, or the amplitude or velocity, in which case use `defloop1`:

```
(use 'overtone.inst.piano)

(defloop1 piano-notes 6
  0 (piano (note :c3))
  2 (piano (note :e3))
  3 (piano (note :g3))
  5 (piano (note :b3))
  )

(defloop1 piano-louder 6
  0   (piano :vel 50)
  1.5 (piano :vel 70)
  3.5 (piano :vel 80)
  4   (piano :vel 100)
)

(bpm 90)
(beats-in-bar 4)
(at-bar 1
        (piano-louder)
        (piano-notes 2)) ;; play for 2 bars
```

Notice that we used fractional beats, that's fine and helps us create off-beats. Also any of the loops accept a number of bars (or really repetitions) to play.

## More examples

See code in [examples](src/overtone_loops/examples) or [music](src/overtone_loops/music).

## The Drum Programming Handbook

I'm working through the exercises in The Drum Programming Handbook and you can see them in the [dph_book folder](src/overtone_loops/dph_book).

## License

Copyright © 2018-2019 Eric Clack

Samples copyright various authors on freesound.org

Distributed under the GNU General Public License v3.0
