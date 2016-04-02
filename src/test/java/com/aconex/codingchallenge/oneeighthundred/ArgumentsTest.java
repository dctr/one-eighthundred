package com.aconex.codingchallenge.oneeighthundred;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArgumentsTest {

    @Test
    public void noArguments() throws Exception {
        Arguments arguments = new Arguments(Collections.emptyList());
        assertEquals("Default dictionaryPath path not taken",
                Constants.DEFAULT_DICTIONARY_PATH,
                arguments.dictionaryPath());
        assertTrue("File list not empty",
                arguments.inputFiles().isEmpty());
    }

    @Test
    public void dictionaryOnly() throws Exception {
        String dictionaryPath = "myDict.txt";
        Arguments arguments = new Arguments(new String[]{"-d", dictionaryPath});
        assertEquals("Provided dictionaryPath path not taken",
                dictionaryPath,
                arguments.dictionaryPath());
        assertTrue("File list not empty",
                arguments.inputFiles().isEmpty());
    }

    @Test
    public void oneFileOnly() throws Exception {
        String file = "file.txt";
        Arguments arguments = new Arguments(new String[]{file});
        assertEquals("Default dictionaryPath path not taken",
                Constants.DEFAULT_DICTIONARY_PATH,
                arguments.dictionaryPath());
        assertEquals("File list does not contain exactly 1 item",
                1,
                arguments.inputFiles().size());
        assertTrue("File list does not contain provided file",
                arguments.inputFiles().contains(file));
    }

    @Test
    public void twoFilesOnly() throws Exception {
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        Arguments arguments = new Arguments(new String[]{file1, file2});
        assertEquals("Default dictionaryPath path not taken",
                Constants.DEFAULT_DICTIONARY_PATH,
                arguments.dictionaryPath());
        assertEquals("File list does not contain exactly 2 items",
                2,
                arguments.inputFiles().size());
        assertTrue("File list does not contain provided file 1",
                arguments.inputFiles().contains(file1));
        assertTrue("File list does not contain provided file 2",
                arguments.inputFiles().contains(file2));
    }

    @Test
    public void dictAndOneFile() throws Exception {
        String dictionaryPath = "myDict.txt";
        String file = "file.txt";
        Arguments arguments = new Arguments(new String[]{"-d", dictionaryPath, file});
        assertEquals("Provided dictionaryPath path not taken",
                dictionaryPath,
                arguments.dictionaryPath());
        assertEquals("File list does not contain exactly 1 item",
                1,
                arguments.inputFiles().size());
        assertTrue("File list does not contain provided file",
                arguments.inputFiles().contains(file));
    }

    @Test
    public void dictAndTwoFiles() throws Exception {
        String dictionaryPath = "myDict.txt";
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        Arguments arguments = new Arguments(new String[]{"-d", dictionaryPath, file1, file2});
        assertEquals("Provided dictionaryPath path not taken",
                dictionaryPath,
                arguments.dictionaryPath());
        assertEquals("File list does not contain exactly 2 items",
                2,
                arguments.inputFiles().size());
        assertTrue("File list does not contain provided file 1",
                arguments.inputFiles().contains(file1));
        assertTrue("File list does not contain provided file 2",
                arguments.inputFiles().contains(file2));
    }

}
