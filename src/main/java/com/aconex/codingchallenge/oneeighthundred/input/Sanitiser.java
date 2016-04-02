package com.aconex.codingchallenge.oneeighthundred.input;

import java.util.Optional;
import java.util.function.Function;

interface Sanitiser extends Function<String, Optional<String>> {
}
