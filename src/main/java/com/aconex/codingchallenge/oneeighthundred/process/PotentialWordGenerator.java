package com.aconex.codingchallenge.oneeighthundred.process;

import java.util.*;
import java.util.function.Function;

public class PotentialWordGenerator implements Function<String, Set<String>> {

    private static final String REPLACEABLE_NUMBERS = "[2-9]+";
    private static final Map<Character, Set<Character>> KEYPAD = new HashMap<>();

    static {
        KEYPAD.put('2', new HashSet<>(Arrays.asList('A', 'B', 'C')));
        KEYPAD.put('3', new HashSet<>(Arrays.asList('D', 'E', 'F')));
        KEYPAD.put('4', new HashSet<>(Arrays.asList('G', 'H', 'I')));
        KEYPAD.put('5', new HashSet<>(Arrays.asList('J', 'K', 'L')));
        KEYPAD.put('6', new HashSet<>(Arrays.asList('M', 'N', 'O')));
        KEYPAD.put('7', new HashSet<>(Arrays.asList('P', 'Q', 'R', 'S')));
        KEYPAD.put('8', new HashSet<>(Arrays.asList('T', 'U', 'V')));
        KEYPAD.put('9', new HashSet<>(Arrays.asList('W', 'X', 'Y', 'Z')));
    }

    @Override
    public Set<String> apply(String number) {
        if (!number.matches(REPLACEABLE_NUMBERS)) {
            return Collections.emptySet();
        }

        Set<String> potentialWords = new HashSet<>(Collections.singletonList(""));
        for (char digit : number.toCharArray()) {
            Set<String> newPotentialWords = new HashSet<>();
            for (String potentialWord : potentialWords) {
                for (char replaceable : KEYPAD.get(digit)) {
                    newPotentialWords.add(potentialWord + replaceable);
                }
            }
            potentialWords = newPotentialWords;
        }

        return potentialWords;
    }
}
