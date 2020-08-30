package com.fun.unit_test;

import com.fun.unit_test.model.Money;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MoneyParameterizedTest {

    private static Object[] getMoney() {
        return new Object[] {
                new Object[] {10, "USD"},
                new Object[] {20, "PHP"},
                new Object[] {30, "EUR"},
        };
    }

    @Test
    @Parameters(method = "getMoney")
    public void constructorShouldSetAmountAndCurrency(int amount, String currency){
        Money money =  new Money(amount, currency);

        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

    private final static int VALID_AMOUNT = 5;
    private final static String VALID_CURRENCY = "PHP";

    private static Object[] getInvalidAmount() {
        return new Integer[][] {
                {-1232},
                {-5},
                {-1},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidAmount")
    public void shouldThrowIAEForInvalidAmount(int invalidAmount){
        new Money(invalidAmount, VALID_CURRENCY);
    }

    private static Object[] getInvalidCurrency() {
        return new String[][] {
                {null},
                {""},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidCurrency")
    public void shouldThrowIAEForInvalidCurrency(String invalidCurrency){
        new Money(VALID_AMOUNT, invalidCurrency);
    }

}

