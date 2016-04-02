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
