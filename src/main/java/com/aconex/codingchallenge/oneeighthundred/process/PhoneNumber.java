package com.aconex.codingchallenge.oneeighthundred.process;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

class PhoneNumber {
    private final static Logger LOGGER = Logger.getLogger(PhoneNumber.class.getName());

    private static final String SEPARATOR = "-";

    private List<Object> phoneNumber;
    private Set<String> dictionary;
    private PotentialWordGenerator generator;

    private PhoneNumber(List<Object> parts) {
        this.phoneNumber = new ArrayList<>();
        parts.forEach(this::addPart);
    }

    PhoneNumber(Object... parts) {
        this(Arrays.asList(parts));
    }

    PhoneNumber(String number) {
        this(Collections.singletonList(number));
    }

    PhoneNumber setWordProcessor(PotentialWordGenerator generator, Set<String> dictionary) {
        this.generator = generator;
        this.dictionary = dictionary;
        return this;
    }

    Set<String> getWordNumbers() {

        Set<String> potentialWords = new HashSet<>(Collections.singletonList(""));
        for (Object numberPart : phoneNumber) {
            Set<String> potentialWordsNew = new HashSet<>();
            Set<String> wordParts = getWordsForPart(numberPart);
            for (String potentialWord : potentialWords) {
                for (String wordPart : wordParts) {
                    potentialWordsNew.add(potentialWord +
                            (potentialWord.length() > 0 ? SEPARATOR : "") +
                            wordPart);
                }
            }
            potentialWords = potentialWordsNew;
        }

        return potentialWords;
    }

    private Set<String> getWordsForPart(Object numberPart) {
        Set<String> result;
        if (numberPart instanceof String) {
            result = generator.apply((String) numberPart).stream()
                    .filter(dictionary::contains)
                    .collect(Collectors.toSet());
        } else if (numberPart instanceof Integer) {
            result = new HashSet<>(Collections.singletonList(numberPart.toString()));
            return result;
        } else {
            System.err.println("aaaaaaaaaaaaaaaaaaaaa");
            result = Collections.emptySet();
        }
        LOGGER.fine(numberPart + " -> " + result);
        return result;
    }

    private void addPart(Object part) {
        if (part instanceof PhoneNumber) {
            this.phoneNumber.addAll(((PhoneNumber) part).phoneNumber);
        } else if ((part instanceof String) || (part instanceof Integer)) {
            this.phoneNumber.add(part);
        } else {
            throw new IllegalArgumentException("Unsupported list element type: " + part.getClass());
        }
    }

    @Override
    public int hashCode() {
        return this.phoneNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) obj;
        return this.phoneNumber.equals(pn.phoneNumber);
    }

    @Override
    public String toString() {
        return this.phoneNumber.stream()
                .map(o -> {
                    if (o instanceof String) {
                        return "'" + o + "'";
                    } else if (o instanceof Integer) {
                        return o.toString();
                    } else {
                        throw new UnsupportedOperationException("This should never happen: " + o.getClass());
                    }
                })
                .collect(Collectors.joining(SEPARATOR));
    }
}
