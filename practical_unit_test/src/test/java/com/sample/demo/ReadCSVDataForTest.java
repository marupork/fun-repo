package com.sample.demo;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadCSVDataForTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/financial.csv", numLinesToSkip = 1)
    void shouldCalculateDiscount(double value, double discount) {
        assertThat(DiscountCalculator.calculateDiscount(value))
                .isEqualTo(discount, Offset.offset(0.0001));

    }
}

class DiscountCalculator {
    static Double calculateDiscount(double value) {
        if (value < 1000) {
            return 0.0;
        } else if (value >= 1000 && value < 2000 ) {
            return  0.01;
        } else if (value >= 2000 && value < 5000 ) {
            return 0.02;
        } else {
            return 0.03;
        }
    }
}
