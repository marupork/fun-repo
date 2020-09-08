package com.sample.demo;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientFundTest {

    private final static int NB_OF_UNITS_AX = 5;
    private final static int NB_OF_UNITS_AY = 1;
    private final static int NB_OF_UNITS_BX = 4;
    private final static int NB_OF_UNITS_BY = 1;
    private BigDecimal FUND_A_VALUE = new BigDecimal(3);
    private BigDecimal FUND_B_VALUE = new BigDecimal(2);

    @Test
    void totalValueShouldBeEqualToSumOfAllFundsValues() {
        ClientFund client = new ClientFund();

        IFund fundA = mock(IFund.class);
        IRegister regAX = mock(IRegister.class);
        IRegister regAY = mock(IRegister.class);
        ICurrentValue currentValueA = mock(ICurrentValue.class);

        IFund fundB = mock(IFund.class);
        IRegister regBX = mock(IRegister.class);
        IRegister regBY = mock(IRegister.class);
        ICurrentValue currentValueB = mock(ICurrentValue.class);

        when(fundA.getRegisterX()).thenReturn(regAX);
        when(fundA.getRegisterY()).thenReturn(regAY);

        when(fundB.getRegisterX()).thenReturn(regBX);
        when(fundB.getRegisterY()).thenReturn(regBY);

        when(regAX.getNbOfUnits()).thenReturn(NB_OF_UNITS_AX);
        when(regAY.getNbOfUnits()).thenReturn(NB_OF_UNITS_AY);
        when(regBX.getNbOfUnits()).thenReturn(NB_OF_UNITS_BX);
        when(regBY.getNbOfUnits()).thenReturn(NB_OF_UNITS_BY);

        when(fundA.getCurrentValue()).thenReturn(currentValueA);
        when(fundB.getCurrentValue()).thenReturn(currentValueB);

        when(currentValueA.getValue()).thenReturn(FUND_A_VALUE);
        when(currentValueB.getValue()).thenReturn(FUND_B_VALUE);

        client.addFund(fundA);
        client.addFund(fundB);
        assertThat(client.getValueOfAllFunds())
                .isEqualByComparingTo(BigDecimal.valueOf((5+1)*3 + (4+1)*2));

    }
}