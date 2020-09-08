package com.sample.demo.model;

public class BankAccount {

    private Integer balance = 0;

    public Integer getBalance() {
        return balance;
    }

    void deposit(Integer amount) {
        this.balance += amount;
    }

    void withdraw(Integer amount) {
        this.balance -= amount;
    }
}
