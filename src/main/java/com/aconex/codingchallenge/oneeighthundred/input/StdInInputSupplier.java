package com.aconex.codingchallenge.oneeighthundred.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

class StdInInputSupplier implements InputSupplier {
    /*
     * Scanner(System.in) reads until input is complete
     * and therefore does not provide an asynchronous stream as NIO does for files,
     * which I used in FileInputSupplier.
     * However as this is (hopefully) not an essential part of the challenge,
     * I stick with this solution.
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
