package com.sample.demo.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountBehaviorTest {

    private BankAccount account = new BankAccount();

    @Test
    void shouldBeEmptyAfterCreation() {
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    void shouldAllowToCreditAccount() {
        account.deposit(100);
        assertThat(account.getBalance()).isEqualTo(100);

        account.deposit(100);
        assertThat(account.getBalance()).isEqualTo(200);
    }

    @Test
    void shouldAllowToDebitAccount() {
        account.deposit(100);
        account.withdraw(30);
        assertThat(account.getBalance()).isEqualTo(70);

        account.withdraw(20);
        assertThat(account.getBalance()).isEqualTo(50);
    }

    @Test
    void shouldNotAllowToDebitAnEmptyAccount() {
        // checking an exception is thrown
        // when withdrawing from empty account
    }

    @Test
    void shouldNotAllowToUseNegativeAmountForCredit() {
        // checking an exception is thrown
        // when depositing negative amount of money
    }

    @Test
    void shouldNotAllowToUseNegativeAmountForDebit() {
        // checking an exception is thrown
        // when withdrawing negative amount of money
    }
}
