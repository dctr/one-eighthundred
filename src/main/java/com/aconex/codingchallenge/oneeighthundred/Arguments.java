package com.aconex.codingchallenge.oneeighthundred;

import java.util.Arrays;
import java.util.List;

/**
 * Parses and provides that arguments that can be provided to this program.
 */
class Arguments {

    private final List<String> inputFiles;
    private final String dictionaryPath;

    Arguments(List<String> arguments) {
        if (arguments.size() > 1 && "-d".equals(arguments.get(0))) {
            dictionaryPath = arguments.get(1);
            inputFiles = arguments.subList(2, arguments.size());
        } else {
            dictionaryPath = Constants.DEFAULT_DICTIONARY_PATH;
            inputFiles = arguments;
        }
    }

    Arguments(String[] arguments) {
        this(Arrays.asList(arguments));
    }

    List<String> inputFiles() {
        return inputFiles;
    }

    String dictionaryPath() {
        return dictionaryPath;
    }

}
