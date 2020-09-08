package com.sample.demo.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class MoneyParamAnnotationTest {

    private static final String VALID_CURRENCY = "USD";
    private static final int VALID_AMOUNT = 7;

    @ParameterizedTest
    @ValueSource(ints = {10, 15, 50})
    void constructorShouldSetAmountAndCurrency(int amount) {
        Money money = new Money(amount, "USD");

        assertThat(money.getAmount()).isEqualTo(amount);
    }

    @ParameterizedTest
    @CsvSource({
            "10, USD",
            "15, EUR",
            "50, PHP"
    })
    void constructorShouldSetAmountAndCurrency(int amount, String currency) {
        Money money = new Money(amount, currency);

        assertThat(money.getAmount()).isEqualTo(amount);
        assertThat(money.getCurrency()).isEqualTo(currency);
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, -32145})
    void constructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(invalidAmount, VALID_CURRENCY));
    }

    private static Stream<String> invalidCurrency() {
        return Stream.of(null, "", " ", "\t");
    }

    @ParameterizedTest
    @MethodSource(value = "invalidCurrency")
    void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(VALID_AMOUNT, invalidCurrency));
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("a", "A"),
                Arguments.of("b", "B"));
    }

    @ParameterizedTest
    @MethodSource(value = "dataProvider")
    void expectsStringAndInt(String x, String y) {
        assertThat(x.toUpperCase()).isEqualTo(y);
    }
}
