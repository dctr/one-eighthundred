# Explanation of choice, design and approach

## Why this challenge

First, at reading of both provided challenges (1-800 and Vehicle Survey),
the 1-800 challenge seemed a little more clearly defined to me.
Second, while reading the 1-800 challenge, a first design approach came to my mind.

## Design and approach

### Approach

I chose a basic IPO (Input-Process-Output) approach where each number
represents an element in the stream pipeline that is composed of the various
input, processing and output stages. This approach suggested itself,
as each element can go through the pipeline individually. It should also facilitate
a functional programming style, as you mentioned functional programming,
Scala and Clojure on your web site's job descriptions.

### Design

The input part is responsible for reading from various sources and sanitising the input.
The process part does all transformations, e.g. splitting of numbers and lookup of words.

While the input is a stream of elements travelling individually through the pipeline,
the dictionary is a static single set. This was an obvious design decision
as it has to be present for all elements throughout the program's run time.

To demonstrate different skills, I used (amongst others):

- The streaming API (again, as you mention FP, Scala and Clojure)
- OOP based class layout
- Recursion (in PhoneNumberSplitter)

### Design Decisions

To keep the code concise for the matters of this challenge, 
I made the following design decisions:

- Few fault checks
    - Dictionary path option has to be first argument
    - `args` parameter to main() is always an array, so no null-check
- Null-Object return values
  (invalid input results in an empty optional, set or stream instead of an exception).
- Use java.util.Logger instead of slf4j + log4j 2 because no frameworks were allowed
- All output via logger instead of finer-grained solution
    - Debug log -> FINE
    - User info -> INFO
    - Errors -> WARNING
- No tests for platform wrapper logic (STD IN / FileIO)
- I used streams in many places, even where input is not available asynchronously
  (as e.g. with java.nio for FileIO).
  I could have used Java's futures, but am not familiar with them (yet).
  I would have been familiar with RxJava but should not use frameworks.
- No integration tests (due to time).
