package com.aconex.codingchallenge.oneeighthundred.inputsupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Stream;

class StdInInputSupplier implements InputSupplier {
    private final static Logger LOGGER = Logger.getLogger(StdInInputSupplier.class.getName());

    @Override
    public Stream<String> get() {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();

        while (scanner.hasNext()) {
            result.add(scanner.nextLine());
        }

        return result.stream();
    }
}
