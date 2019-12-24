# Overtone Loops

A simple, yet flexible, loop syntax for Overtone, to make drum patterns or other repeating phrases. Have a look at a quick demo video: https://youtu.be/4Tj7AIRwK9w

Currently this work is highly experimental. Feel free to leave suggestions on the Issues page. I should point out that I'm not a talented drummer!

## How do you program loops?

First load in Overtone Live and Loops namespaces `loops` and `samples`:

```
(use 'overtone.live
     'overtone-loops.loops
     'overtone-loops.samples)
```

Then create loop players with an instrument and a list of beats. Each value in the list is an amplitude.

```
;; clear any previous patterns
(set-up) 

;;                        beat   1 2 3 4 5 6 7 8
(def hats
  (loop-player 1 cymbal-closed  [_ 5 _ 5 _ 5 _ 5]))
(def kicks 
  (loop-player 1 bass-hard      [7 _ 2 _ 7 6 2 _]))
(def claps
  (loop-player 1 clap           [_ _ 4 _]))
```

The parameters to `loop-player` are: beat-fraction where 1 is whole beats, 1/2 is half beats and so on; the instrument to play; and a list of amplitudes to pass to the instrument on each beat, where `_` is equivalent to `0`, a muted beat. For ease of coding the scale of amplitudes are 0 (silence) to 9 (full), these are converted to a number between 0 and 1, which is what the instrument expects. 

To play these loops just call the loop-name function with a timer from `(metro)`, do set the `bpm` first to ensure the correct playback speed.

```
(bpm 200)
(hats (metro))
(kicks (metro))
(claps (metro))
;; To stop
(stop)
```

Usually you'll want some sort of scheduling, use `at-bar` to set the appropriate time, replacing the above code with:

```
(beats-in-bar 4)
(bpm 200)
(at-bar 1 (hats) (kicks))
(at-bar 3 (claps))
```

Now, when a loop is playing you can give it an alternative beat pattern, like so:

```
(beats-in-bar 4)
(at-bar 1 (hats) (kicks))
(at-bar 3 (claps))

(at-bar 5 (hats  [9 3 9 3 9 5 6 7])
          (kicks [_ _ 2 _ _ 2 _ _]))

;; return to previous patterns
(at-bar 7 (hats :pop)
          (kicks :pop)) 
```

Here's an example with half and third beats:

```
;;                           beat 1  &   2  &   3  &   4  &
(def hats
  (loop-player 1/2 cymbal-closed [_  5   _  5   _  5   _  5 ]))
(def kicks
  (loop-player 1/2 bass-hard     [7  _   2  _   7  6   2  _ ]))
(def claps   
  (loop-player 1   clap          [_      _      7      _    ]))
(def bells
  (loop-player 1/3 cowbell       [_ _ _  5 _ 1  5 1 _  _ 1 5]))
```

Then run with:

```
(bpm 120)
(at-bar 1 (hats) (kicks) (claps) (bells))
```

Check out the documentation for `at-bar` and `on-next-bar` to find out more about scheduling. E.g. `(odoc at-bar)`.

## More than amplitude

If you want to send your instrument more than just an amplitude you can use a nested loop syntax. For example, here's how we can program a note and amplitude with a helper function `k`:

```
(use 'overtone.inst.piano)

(defn k [[anote amp]]
  (piano (note anote) :vel (* amp 10)))

(def melody1 
  (loop-player 1 k [[:g4 8] [:a4 4] [:b4 6] [:c5 7]]))
  
(melody1 (metro))
```

## More examples

See code in [examples](src/overtone_loops/examples) or [music](src/overtone_loops/music).

## The Drum Programming Handbook

I'm working through the exercises in The Drum Programming Handbook and you can see them in the [dph_book folder](src/overtone_loops/dph_book).

## License

Copyright © 2018-2019 Eric Clack

Samples copyright various authors on freesound.org

Distributed under the GNU General Public License v3.0
