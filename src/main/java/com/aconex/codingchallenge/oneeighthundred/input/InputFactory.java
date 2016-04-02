package com.aconex.codingchallenge.oneeighthundred.input;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFactory {

    private static final Sanitiser NUMBER_SANITISER = new NumberSanitiser();
    private static final Sanitiser WORD_SANITISER = new WordSanitiser();

    public static Stream<String> numbersFromStdIn() {
        return fromGeneric(new StdInInputSupplier(), NUMBER_SANITISER);
    }

    public static Stream<String> numbersFromFiles(List<String> files) {
        return fromGeneric(new FileInputSupplier(files), NUMBER_SANITISER);
    }

    public static Set<String> dictionaryFromFile(String path) {
        return fromGeneric(new FileInputSupplier(Collections.singletonList(path)), WORD_SANITISER)
                .collect(Collectors.toSet());
    }

    private static Stream<String> fromGeneric(InputSupplier supplier, Sanitiser sanitiser) {
        return supplier
                .get()
                .map(sanitiser)
                .filter(Optional::isPresent)
                .map(Optional::get);
    }

}
