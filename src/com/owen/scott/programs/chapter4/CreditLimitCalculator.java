package com.owen.scott.programs.chapter4;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class CreditLimitCalculator implements Runnable {
    private static final String ENTER_THE = "Enter the customer's ";
    private static final String OR_QUIT = " or type '!' to quit.";
    private static final String EXCLAMATION = "!";

    private final Scanner sc;

    public CreditLimitCalculator() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(ENTER_THE + "account number" + OR_QUIT);
            String account = InputUtils.getInputString(sc, (String str) -> true);
            if (account.equalsIgnoreCase(EXCLAMATION)) break;
            System.out.println(ENTER_THE + "balance at the beginning of the month.");
            double balance = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
            System.out.println(ENTER_THE + "total of all items charged by the customer this month.");
            double charges = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
            System.out.println(ENTER_THE + "total of all credits applied to the customer's account this month.");
            double credits = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
            System.out.println(ENTER_THE + "allowed credit limit.");
            double limit = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
            double newBalance = balance + charges - credits;
            System.out.println("New balance: " + newBalance);
            if (newBalance > limit) System.out.println("Credit limit exceeded.");
        }
    }
}
