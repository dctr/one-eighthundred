package com.aconex.codingchallenge.oneeighthundred.process;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class Processor implements Function<String, Set<String>> {

    private final Set<String> dictionary;

    public Processor(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public Set<String> apply(String s) {
        Set<String> result = new HashSet<>();
        result.add("dummy1");
        result.add("dummy2");
        return result;
    }
}
