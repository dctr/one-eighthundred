package com.aconex.codingchallenge.oneeighthundred.input;

import java.util.Optional;
import java.util.function.Function;

interface Sanitiser extends Function<String, Optional<String>> {
    /**
     * This method sanitises unreliable user input.
     * The rules by which to sanitise depend on the implementation
     * Returns an empty optional,
     * if the input does not match the rules the sanitiser implements.
     *
     * @param s The input to sanitise.
     * @return The sanitised string or an empty optional.
     */
    Optional<String> apply(String s);
}
