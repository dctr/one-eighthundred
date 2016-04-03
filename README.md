# 1-800-CODING-CHALLENGE

Map a list of phone numbers to a list of words that can be made out of them using a keypad.

`2255.63` will e.g. output (amongst others) "CALL-ME", `435 5696 753` will output "HELLO-WORLD". 

## Example usage

Read phone numbers from one or multiple input files:

```sh
one-eighthundred-<version>.jar [-d dictionary.txt] input.txt [input2.txt [input3.txt [...]]]
```

Provide phone number through STDIN:

```sh
one-eighthundred-<version>.jar [-d dictionary.txt]
1-800-234567
1-800-987654

```

The optional `-d` switch provides a custom dictionary of possible words to use.
The default dictionary can be found besides the JAR file.

## Getting Started

### Build

To build the project, just run `mvn clean package`.
The built JAR along with sample dictionaries and inputs can be found in the `target` directory.

### Test

Building with `mvn clean package` already runs unit tests.

`mvn clean verify` also runs integration tests, but none are present as of yet.

## Technology

- Java Stream API
- JUnit for unit tests

## Author

David Christ <david.christ@genitopia.org>

## Acknowledgments

- The people of Aconex Ltd. for the opportunity
- Recruiter Ryan Lynch of Greythorn Pty Ltd for the referral
