package com.owen.scott.programs.chapter3;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.chapter3.Account;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class AccountTest implements Runnable {
    private final Scanner sc;

    public AccountTest() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        Account account1 = new Account("Jane Green", 50);
        Account account2 = new Account("John Blue", -7.53);

        printBalances(account1, account2);

        System.out.println("Enter deposit amount for account1.");
        double depositAmount = InputUtils.getInputDouble(sc, (Double d) -> true);
        System.out.printf("Adding %.2f to account1 balance%n%n", depositAmount);
        account1.deposit(depositAmount);

        printBalances(account1, account2);

        System.out.println("Enter deposit amount for account2: ");
        depositAmount = InputUtils.getInputDouble(sc, (Double d) -> true);
        System.out.printf("Adding %.2f to account2 balance%n%n", depositAmount);
        account2.deposit(depositAmount);

        printBalances(account1, account2);

        System.out.println("Enter withdrawal amount for account1.");
        double withdrawalAmount = InputUtils.getInputDouble(sc, (Double d) -> true);
        System.out.printf("Withdrawing %.2f from account1 balance%n%n", withdrawalAmount);
        account1.withdraw(withdrawalAmount);

        printBalances(account1, account2);

        System.out.println("Enter withdrawal amount for account2: ");
        withdrawalAmount = InputUtils.getInputDouble(sc, (Double d) -> true);
        System.out.printf("Withdrawing %.2f from account2 balance%n%n", withdrawalAmount);
        account2.withdraw(withdrawalAmount);

        printBalances(account1, account2);

        System.out.println("Test complete!");
    }

    private void printBalances(Account ... accounts) {
        for (Account account : accounts) {
            System.out.printf("%s balance: $%.2f%n", account.getName(), account.getBalance());
        }
    }
}
