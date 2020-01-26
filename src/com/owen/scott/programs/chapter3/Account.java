package com.owen.scott.programs.chapter3;

public class Account {
    private static final String BALANCE_EXCEEDED = "Withdrawal amount exceeded account balance.";

    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;
        if (balance > 0) this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (balance - amount >= 0) balance -= amount;
        else System.out.println(BALANCE_EXCEEDED);
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
