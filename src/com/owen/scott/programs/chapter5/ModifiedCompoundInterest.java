package com.owen.scott.programs.chapter5;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class ModifiedCompoundInterest implements Runnable {
    private final Scanner sc;

    public ModifiedCompoundInterest() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        double amount;
        System.out.println("Enter the initial amount before interest.");
        double principal = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
        System.out.println("Enter the interest rate as a decimal ie 1% is 0.01 and so on and so forth.");
        double rate = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
        System.out.println("Enter the number of years the interest will be compounded.");
        double years = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
        System.out.printf("%s%20s%n", "Year", "Amount on deposit");
        for (int i = 0; i <= years; i++) {
            amount = principal * Math.pow(rate + 1, i);
            System.out.printf("%4d%,20.2f%n", i, amount);
        }
    }
}
