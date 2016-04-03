package com.aconex.codingchallenge.oneeighthundred.process;

import com.aconex.codingchallenge.oneeighthundred.Constants;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Processor implements Function<String, Set<String>> {
    private final static Logger LOGGER = Logger.getLogger(Processor.class.getName());

    private final Set<String> dictionary;
    private final PotentialWordGenerator potentialWordGenerator;
    private final PhoneNumberSplitter phoneNumberSplitter;

    public Processor(Set<String> dictionary) {
        this.dictionary = dictionary;
        this.potentialWordGenerator = new PotentialWordGenerator();
        this.phoneNumberSplitter = new PhoneNumberSplitter();
    }

    /**
     * Processes a sanitised phone number to produce a set of word-numbers.
     * @param number A sanitised phone number.
     * @return A set of possible words, that can be made from the supplied number.
     */
    @Override
    public Set<String> apply(String number) {
        return phoneNumberSplitter.apply(number)
                .flatMap(this::getWordNumbers)
                .collect(Collectors.toSet());

    }

    private Stream<String> getWordNumbers(PhoneNumber phoneNumber) {

        Set<String> potentialWords = new HashSet<>(Collections.singletonList(""));
        for (Object numberPart : phoneNumber.getParts()) {
            Set<String> potentialWordsNew = new HashSet<>();
            Set<String> wordParts = getWordsForPart(numberPart);
            for (String potentialWord : potentialWords) {
                for (String wordPart : wordParts) {
                    potentialWordsNew.add(potentialWord +
                            (potentialWord.length() > 0 ? Constants.SEPARATOR : "") +
                            wordPart);
                }
            }
            potentialWords = potentialWordsNew;
        }

        return potentialWords.stream();
    }

    private Set<String> getWordsForPart(Object numberPart) {
        Set<String> result;
        if (numberPart instanceof String) {
            result = potentialWordGenerator.apply((String) numberPart)
                    .filter(dictionary::contains)
                    .collect(Collectors.toSet());
        } else if (numberPart instanceof Integer) {
            result = new HashSet<>(Collections.singletonList(numberPart.toString()));
            return result;
        } else {
            LOGGER.warning("Invalid type in phone number parts of processor: " + numberPart.getClass());
            result = Collections.emptySet();
        }
        return result;
    }

}
