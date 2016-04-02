package com.aconex.codingchallenge.oneeighthundred;

import com.aconex.codingchallenge.oneeighthundred.inputsupplier.InputFactory;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        setUpLogging();

        Arguments arguments = new Arguments(args);

        Stream<String> input;

        if (arguments.inputFiles().isEmpty()) {
            LOGGER.fine("No input file paths provided.");
            LOGGER.info("Please enter the desired phone numbers, one per line.");
            LOGGER.info("End the input with 'CTRL + D' on an empty line.");
            input = InputFactory.fromStdIn();
        } else {
            input = Stream.empty();
        }

        input.forEach(System.out::println);
    }

    private static void setUpLogging() {
        Logger rootLog = Logger.getLogger("");
        rootLog.setLevel(Level.FINE);
        rootLog.getHandlers()[0].setLevel(Level.FINE);
    }

}
