package com.sample.demo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    private BankAccount account = new BankAccount();

    @Test
    void testBalance() {
        account.deposit(200);
        assertThat(account.getBalance()).isEqualTo(200);
    }

    @Test
    void testDeposit() {
        account.deposit(100);
        assertThat(account.getBalance()).isEqualTo(100);

        account.deposit(100);
        assertThat(account.getBalance()).isEqualTo(200);
    }

    @Test
    void testWithdraw() {
        account.deposit(100);
        account.withdraw(30);
        assertThat(account.getBalance()).isEqualTo(70);

        account.withdraw(20);
        assertThat(account.getBalance()).isEqualTo(50);
    }

}
