package com.aconex.codingchallenge.oneeighthundred.inputsupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Stream;

class StdInInputSupplier implements InputSupplier {
    private final static Logger LOGGER = Logger.getLogger(StdInInputSupplier.class.getName());

    /*
     * Scanner(System.in) reads until input is complete
     * and therefore does not provide an asynchronous stream as NIO does for files.
     * However as this is (hopefully) not the essential part of the challenge,
     * I stick with this solution and will focus on the core logic instead.
     */
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
