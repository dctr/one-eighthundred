package com.aconex.codingchallenge.oneeighthundred;

import com.aconex.codingchallenge.oneeighthundred.input.InputFactory;
import com.aconex.codingchallenge.oneeighthundred.process.Processor;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        setUpLogging();
        Arguments arguments = new Arguments(args);
        Set<String> dictionary = getDictionary(arguments);
        Stream<String> inputs = getInput(arguments);
        Processor processor = new Processor(dictionary);
        printOutput(inputs, processor);
    }

    private static void printOutput(Stream<String> inputs, Processor processor) {
        inputs
                .map(input -> new AbstractMap.SimpleEntry<>(input, processor.apply(input)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((s, strings) -> {
                    if (strings.isEmpty()) {
                        return;
                    }
                    System.out.println(s + ":");
                    strings.forEach(s1 -> System.out.println("    " + s1));
                });
    }

    private static Stream<String> getInput(Arguments arguments) {
        Stream<String> input;
        if (arguments.inputFiles().isEmpty()) {
            LOGGER.info("Please enter the desired phone numbers, one per line.");
            LOGGER.info("End the input by typing 'CTRL + D' (Unix) or 'CTRL + Z' + Return (Windows) on an empty line.");
            input = InputFactory.numbersFromStdIn();
        } else {
            input = InputFactory.numbersFromFiles(arguments.inputFiles());
        }
        return input;
    }

    private static Set<String> getDictionary(Arguments arguments) {
        return InputFactory.dictionaryFromFile(arguments.dictionaryPath());
    }

    private static void setUpLogging() {
        Logger rootLog = Logger.getLogger("");
        rootLog.setLevel(Level.FINE);
        rootLog.getHandlers()[0].setLevel(Level.FINE);
    }

}
