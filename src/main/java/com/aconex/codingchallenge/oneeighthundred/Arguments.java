package com.aconex.codingchallenge.oneeighthundred;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Arguments {
    private final static Logger LOGGER = Logger.getLogger(Arguments.class.getName());

    private final List<String> inputFiles;
    private final String dictionaryPath;

    public Arguments(List<String> arguments) {
        if (arguments.size() > 1 && "-d".equals(arguments.get(0))) {
            dictionaryPath = arguments.get(1);
            inputFiles = arguments.subList(2, arguments.size());
        } else {
            dictionaryPath = Constants.DEFAULT_DICTIONARY_PATH;
            inputFiles = arguments;
        }
        LOGGER.fine("Parsed args; dict: " + dictionaryPath() + "; file count: " + inputFiles().size());
    }

    public Arguments(String[] arguments) {
        this(Arrays.asList(arguments));
    }

    public List<String> inputFiles() {
        return inputFiles;
    }

    public String dictionaryPath() {
        return dictionaryPath;
    }
}
