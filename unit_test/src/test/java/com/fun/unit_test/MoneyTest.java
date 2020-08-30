package com.fun.unit_test;

import com.fun.unit_test.model.Money;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoneyTest {

    @Test
    public void constructorShouldSetAmountAndCurrency(){
        Money money = new Money(10, "PHP");

        assertEquals(10, money.getAmount());
        assertEquals("PHP", money.getCurrency());
    }
}
