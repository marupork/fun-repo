package com.sample.demo;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientFundOOTest {

    private final static BigDecimal VALUE_A = new BigDecimal(9);
    private final static BigDecimal VALUE_B = new BigDecimal(2);

    @Test
    void totalValueShouldBeEqualToSumOfAllFundsValues() {
        ClientFundOO client = new ClientFundOO();

        IFundOO fundA = mock(IFundOO.class);
        IFundOO fundB = mock(IFundOO.class);

        when(fundA.getValue()).thenReturn(VALUE_A);
        when(fundB.getValue()).thenReturn(VALUE_B);

        client.addFund(fundA);
        client.addFund(fundB);

        assertThat(client.getValueOfAllFunds())
                .isEqualByComparingTo(VALUE_A.add(VALUE_B));
    }

}
