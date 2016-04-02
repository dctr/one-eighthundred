package com.aconex.codingchallenge.oneeighthundred.inputsupplier;

import java.util.function.UnaryOperator;

class Sanitiser implements UnaryOperator<String> {
    @Override
    public String apply(String s) {
        return s;
    }
}
