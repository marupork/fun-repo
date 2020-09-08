package com.sample.demo;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpression {

    public static List<String> capitalizeAll(List<String> input) {
        return input.stream()
            .map(LambdaExpression::someComplexOperation)
            .collect(Collectors.toList());
    }

    static String someComplexOperation(String s) {
        return s.toUpperCase();
    }
}
