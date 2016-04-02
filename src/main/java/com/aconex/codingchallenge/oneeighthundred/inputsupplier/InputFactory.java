package com.aconex.codingchallenge.oneeighthundred.inputsupplier;

import java.util.List;
import java.util.stream.Stream;

public class InputFactory {

    private static final Sanitiser SANITISER = new Sanitiser();

    public static Stream<String> fromStdIn() {
        return fromGeneric(new StdInInputSupplier());
    }

    public static Stream<String> fromFiles(List<String> files) {
        return fromGeneric(new FileInputSupplier(files));
    }

    private static Stream<String> fromGeneric(InputSupplier supplier) {
        return supplier
                .get()
                .map(SANITISER);
    }

}
