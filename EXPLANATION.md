# Why this challenge

At a first reading of both provided challenges (1-800 and Vehicle Survey),
it seemed to me the 1-800 challenge was a little more clearly defined.
Second, while reading the 1-800 challenge, a first design approach came to my mind.

# Design and approach

I chose a basic IPO (Input-Process-Output) approach relying on sets and streams.
The input part is also responsible for sanitising the input.
The process part does all transformations.

To demonstrate different skills, I used (amongst others):

- The streaming API (as you mention Scala and Clojure in your job descriptions)
- OOP based class layout
- Recursion (in PhoneNumberSplitter)

The users input is represented as stream of things,
as each element of it can go separately through the IPO pipeline.
The dictionary however is represented as set,
as it has to be present in whole and throughout the program for every input element.

## Design Decisions

To keep the code concise for the matters of this challenge, I made the following design decisions:

- Few fault checks
    - Dictionary path option has to be first argument
    - `args` parameter to main() is always an array, so no null-check
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
