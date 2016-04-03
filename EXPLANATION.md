# Reason Why this one

- Clearer, less assumptions left to me

# Assumptions

- Few fault checks
    - Dictionary path option has to be first argument
    - `args` parameter to main() is always an array, so no null-check

# Design Decisions

- 1.0.0 instead of 1.0 because semver
- java.util.Logger instead of slf4j + log4j 2 because no frameworks
- All output via logger instead of finer-grained solution
    - Debug log -> FINE
    - user info -> INFO
    - Errors -> WARNING
- No tests for platform wrapper logic (STD IN / FileIO)
- Input as Stream as each item is processed through a pipeline
- Dictionary as Set, as it is accessed for each steamed item and only should contain unique items
- Implementing Stream<> everywhere, but is not async, as I am not yet skilled in CompleteableFuture
