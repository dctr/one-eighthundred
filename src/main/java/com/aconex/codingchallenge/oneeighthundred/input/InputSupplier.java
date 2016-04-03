package com.aconex.codingchallenge.oneeighthundred.input;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Provides input from a source that depends on the implementation as stream of strings.
 * Each element in the stream represents a single line of the input.
 */
interface InputSupplier extends Supplier<Stream<String>> {
}
