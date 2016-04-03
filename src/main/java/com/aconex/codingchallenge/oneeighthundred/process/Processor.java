package com.aconex.codingchallenge.oneeighthundred.process;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Processor implements Function<String, Set<String>> {

    private final Set<String> dictionary;

    public Processor(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public Set<String> apply(String s) {
        // USE COMPOSE!
        return new PotentialWordGenerator().apply(s).stream()
                .filter(dictionary::contains)
                .collect(Collectors.toSet());
    }

    private Set<Set<String>> numberToSetOfLetters(String s) {
        Set<Set<String>> result = new HashSet<>();
//        result.add(numberToPotentialWords(s));
        return result;
    }

}
