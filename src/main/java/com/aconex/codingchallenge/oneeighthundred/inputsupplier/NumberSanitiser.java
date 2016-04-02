package com.aconex.codingchallenge.oneeighthundred.inputsupplier;

import java.util.Optional;

class NumberSanitiser extends AbstractSanitiser {

    private static final String DIGIT = "\\d+";

    @Override
    public Optional<String> apply(String s) {
        return wrapOptional(s, super.sanitiseGeneric(s), DIGIT);
    }
}
