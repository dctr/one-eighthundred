package com.aconex.codingchallenge.oneeighthundred.input;

import java.util.Optional;

class NumberSanitiser extends AbstractSanitiser {

    private static final String DIGIT = "\\d+";

    @Override
    public Optional<String> apply(String s) {
        return wrapOptional(s, removePrefix(super.sanitiseGeneric(s)), DIGIT);
    }

    private String removePrefix(String s) {
        if (s.startsWith("1800")) {
            return s.substring(4);
        }
        return s;
    }
}
