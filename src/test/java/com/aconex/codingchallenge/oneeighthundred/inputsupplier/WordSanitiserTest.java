package com.aconex.codingchallenge.oneeighthundred.inputsupplier;

import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class WordSanitiserTest {
    private Sanitiser sanitiser;

    @Before
    public void setUp() throws Exception {
        this.sanitiser = new WordSanitiser();
    }

    @Test
    public void makesUpperCase() throws Exception {
        String input = "fOo";
        String expected = "FOO";
        Optional<String> actual = sanitiser.apply(input);
        assertTrue("Input could not be converted", actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    public void removesApostrophe() throws Exception {
        String input = "f'Oo";
        String expected = "FOO";
        Optional<String> actual = sanitiser.apply(input);
        assertTrue("Input could not be converted", actual.isPresent());
        assertEquals(expected, actual.get());
    }

    @Test
    public void doesNotRemoveNumbers() throws Exception {
        String input = "fOo 1";
        Optional<String> actual = sanitiser.apply(input);
        assertFalse("Input COULD be converted: " + actual, actual.isPresent());
    }

}
