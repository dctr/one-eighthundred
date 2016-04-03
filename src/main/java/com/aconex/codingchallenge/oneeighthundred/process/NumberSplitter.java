package com.aconex.codingchallenge.oneeighthundred.process;

import java.util.Set;
import java.util.function.Function;

public class NumberSplitter implements Function<String, Set<String>> {
    private static final int MINIMUM_WORD_LENGTH = 1;
    @Override
    public Set<String> apply(String s) {
        for (int digitsInBetween = 0; digitsInBetween <= 1; digitsInBetween++) {
            int maximumNumberOfWords =
                    // Maximum Number of words without digits in between
                    (s.length() / MINIMUM_WORD_LENGTH) -
                    // Assuming one digit in between each word.
                    ((s.length() / MINIMUM_WORD_LENGTH) * digitsInBetween);
            for (int numberOfWords = 1; numberOfWords < maximumNumberOfWords; numberOfWords++) {

            }
        }
        return null;
    }
}
