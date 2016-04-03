package com.aconex.codingchallenge.oneeighthundred.input;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Provides sanitised user input from different sources.
 * Note: Sanitising will remove elements from the input not matching the sanitiser's rules.
 */
public class InputFactory {

    private static final Sanitiser NUMBER_SANITISER = new NumberSanitiser();
    private static final Sanitiser WORD_SANITISER = new WordSanitiser();

    /**
     * Provides a sanitised stream of lines read from STD IN.
     * @return A sanitised stream of lines read from STD IN.
     */
    public static Stream<String> numbersFromStdIn() {
        return fromGeneric(new StdInInputSupplier(), NUMBER_SANITISER);
    }

    /**
     * Provides a sanitised stream of lines read from the provided files.
     * Files that could not be read will be skipped.
     * @param files A list of file names.
     * @return A sanitised stream of lines read from the provided files. Order preservation not guaranteed.
     */
    public static Stream<String> numbersFromFiles(List<String> files) {
        return fromGeneric(new FileInputSupplier(files), NUMBER_SANITISER);
    }

    /**
     * Reads a file into a set of strings, each representing one line of the file.
     * @param path A path to read from.
     * @return A sanitised set of lines from the file.
     */
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
