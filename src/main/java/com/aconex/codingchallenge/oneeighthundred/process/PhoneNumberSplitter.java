package com.aconex.codingchallenge.oneeighthundred.process;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

class PhoneNumberSplitter implements Function<String, Set<PhoneNumber>> {

    // Minimum word length = 1, aka "a"
    // At most 1 digit in between, 1800 number length = 6
    // => maximum number of 6 words (a a a a a a)
    // => maximum number of digits = minimum word length / 2, aka every other (a 1 a 1 a 1)

    @Override
    public Set<PhoneNumber> apply(String number) {
        return splitPhoneNumberFirstRun(number);
    }

    // For the first run we have to consider, that the digit might also be at first and/or last position.
    private Set<PhoneNumber> splitPhoneNumberFirstRun(String number) {
        Set<PhoneNumber> result = new HashSet<>();

        Integer firstDigit = Integer.parseInt(number.substring(0, 1));
        Integer lastDigit = Integer.parseInt(number.substring(number.length() - 1, number.length()));
        String withFirstDigit = number.substring(1);
        String withLastDigit = number.substring(0, number.length() - 1);
        String withFirstAndLastDigit = number.substring(1, number.length() - 1);

        result.add(new PhoneNumber(firstDigit, withFirstDigit));
        result.add(new PhoneNumber(withLastDigit, lastDigit));
        result.add(new PhoneNumber(firstDigit, withFirstAndLastDigit, lastDigit));
        result.addAll(splitPhoneNumber(number));

        return result;
    }

    private Set<PhoneNumber> splitPhoneNumber(String number) {
        Set<PhoneNumber> result = new HashSet<>();

        if (number.length() == 0) {
            return result;
        }

        result.add(new PhoneNumber(number));

        if (number.length() == 1) {
            return result;
        }

        // => wholeNumber | firstHalf - secondHalf | firstHalf - middleDigit - secondHalf

        for (int split = 1; split < number.length(); split++) {
            String leftString = number.substring(0, split);
            String rightString = number.substring(split, number.length());
            Set<PhoneNumber> leftParts = splitPhoneNumber(leftString);
            Set<PhoneNumber> rightParts = splitPhoneNumber(rightString);
            result.addAll(merge(leftParts, rightParts, null));

            String leftStringDigit = number.substring(0, split);
            Integer digit = Integer.parseInt(number.substring(split, split + 1));
            String rightStringDigit = number.substring(split + 1, number.length());
            Set<PhoneNumber> leftPartsDigit = splitPhoneNumber(leftStringDigit);
            Set<PhoneNumber> rightPartsDigit = splitPhoneNumber(rightStringDigit);
            result.addAll(merge(leftPartsDigit, rightPartsDigit, digit));
        }

        return result;
    }

    private Set<PhoneNumber> merge(Set<PhoneNumber> leftParts, Set<PhoneNumber> rightParts, Integer digit) {
        Set<PhoneNumber> result = new HashSet<>();
        for (PhoneNumber leftPart : leftParts) {
            for (PhoneNumber rightPart : rightParts) {
                if (digit == null) {
                    result.add(new PhoneNumber(leftPart, rightPart));
                } else {
                    result.add(new PhoneNumber(leftPart, digit, rightPart));
                }
            }
        }
        return result;
    }

}
