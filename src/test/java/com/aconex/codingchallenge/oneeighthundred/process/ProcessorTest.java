package com.aconex.codingchallenge.oneeighthundred.process;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProcessorTest {

    private Processor processor;

    @Before
    public void setUp() throws Exception {
        this.processor = new Processor(new HashSet<>(Arrays.asList(
                "CALL",
                "HELLO",
                "HIRE",
                "ME",
                "WORLD"
        )));
    }

    @Test
    public void testChallenge() throws Exception {
        String input = "225563";
        Set<String> actual = processor.apply(input);
        assertTrue(actual.contains("CALL-ME"));
    }

    @Test
    public void testHelloWorld() throws Exception {
        String input = "4355696753";
        Set<String> actual = processor.apply(input);
        assertTrue(actual.contains("HELLO-WORLD"));

    }

    @Test
    public void testHireMe() throws Exception {
        String input = "447363";
        Set<String> actual = processor.apply(input);
        assertTrue(actual.contains("HIRE-ME"));

    }

}
