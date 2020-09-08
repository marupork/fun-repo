package com.sample.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaExpressionTest {

    @Test
    void testComplexMethod() {
        assertThat(LambdaExpression.someComplexOperation("a")).isEqualTo("A");
    }
}
