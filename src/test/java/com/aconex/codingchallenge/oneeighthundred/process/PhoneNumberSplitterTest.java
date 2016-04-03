package com.aconex.codingchallenge.oneeighthundred.process;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PhoneNumberSplitterTest {
    private PhoneNumberSplitter splitter;

    @Before
    public void setUp() throws Exception {
        this.splitter = new PhoneNumberSplitter();
    }

    @Test
    public void splitThreeDigits() throws Exception {
        String input = "222";
        Set<PhoneNumber> expected = new HashSet<>();
        expected.add(new PhoneNumber("2", "2", "2"));
        expected.add(new PhoneNumber("2", 2, "2"));
        expected.add(new PhoneNumber(2, "2", 2));
        expected.add(new PhoneNumber("2", "22"));
        expected.add(new PhoneNumber(2, "22"));
        expected.add(new PhoneNumber("22", "2"));
        expected.add(new PhoneNumber("22", 2));
        expected.add(new PhoneNumber("222"));
        Set<PhoneNumber> actual = splitter.apply(input).collect(Collectors.toSet());
        assertEquals(expected, actual);
    }

    @Test
    public void containsChallengeInput() throws Exception {
        String input = "225563";
        Set<PhoneNumber> actual = splitter.apply(input).collect(Collectors.toSet());
        assertTrue(actual.contains(new PhoneNumber("2255", "63")));
    }

}
