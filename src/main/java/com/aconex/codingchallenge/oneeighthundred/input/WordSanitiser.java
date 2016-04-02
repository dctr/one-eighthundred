package com.aconex.codingchallenge.oneeighthundred.input;

import java.util.Optional;

class WordSanitiser extends AbstractSanitiser {

    private static final String UPPERCASE = "\\p{Upper}+";

    @Override
    public Optional<String> apply(String s) {
        return wrapOptional(s, super.sanitiseGeneric(s).toUpperCase(), UPPERCASE);
    }

}
