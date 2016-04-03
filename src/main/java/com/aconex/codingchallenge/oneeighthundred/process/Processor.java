package com.aconex.codingchallenge.oneeighthundred.process;

import java.util.Set;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Processor implements Function<String, Set<String>> {

    private final Set<String> dictionary;
    private final PotentialWordGenerator potentialWordGenerator;
    private final PhoneNumberSplitter phoneNumberSplitter;

    public Processor(Set<String> dictionary) {
        this.dictionary = dictionary;
        this.potentialWordGenerator = new PotentialWordGenerator();
        this.phoneNumberSplitter = new PhoneNumberSplitter();
    }

    @Override
    public Set<String> apply(String s) {
        return phoneNumberSplitter.apply(s).stream()
            .flatMap(phoneNumber -> phoneNumber
                    .setWordProcessor(potentialWordGenerator, dictionary)
                    .getWordNumbers()
                    .stream())
            .collect(Collectors.toSet());

    }

}
