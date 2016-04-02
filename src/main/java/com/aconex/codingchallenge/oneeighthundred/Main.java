package com.aconex.codingchallenge.oneeighthundred;

import com.aconex.codingchallenge.oneeighthundred.input.InputFactory;

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
            LOGGER.fine("No input file paths provided");
            LOGGER.info("Please enter the desired phone numbers, one per line.");
            LOGGER.info("End the input by typing 'CTRL + D' (Unix) or 'CTRL + Z' + Return (Windows) on an empty line.");

            input = InputFactory.numbersFromStdIn();
        } else {
            LOGGER.fine("Reading from provided files list");

            input = InputFactory.numbersFromFiles(arguments.inputFiles());
        }

        input.forEach(System.out::println);
    }

    private static void setUpLogging() {
        Logger rootLog = Logger.getLogger("");
        rootLog.setLevel(Level.FINE);
        rootLog.getHandlers()[0].setLevel(Level.FINE);
    }

}
