package com.aconex.codingchallenge.oneeighthundred.inputsupplier;

import java.util.Optional;
import java.util.function.Function;

interface Sanitiser extends Function<String, Optional<String>> {
}
