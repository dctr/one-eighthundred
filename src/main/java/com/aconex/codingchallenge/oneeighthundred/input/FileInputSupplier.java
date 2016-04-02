package com.aconex.codingchallenge.oneeighthundred.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

class FileInputSupplier implements InputSupplier {

    private final static Logger LOGGER = Logger.getLogger(FileInputSupplier.class.getName());
    private final List<String> filePaths;

    FileInputSupplier(List<String> filePaths) {
        this.filePaths = filePaths;
    }

    @Override
    public Stream<String> get() {
        return filePaths.stream()
                .flatMap(filePath -> {
                    try {
                        return Files.lines(Paths.get(filePath));
                    } catch (IOException e) {
                        LOGGER.warning("File " + filePath + " could not be read, skipping.");
                        return Stream.empty();
                    }
                });
    }

}
