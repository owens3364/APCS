package com.owen.scott.programs.chapter2;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class OddOrEven implements Runnable {
    private static final String ENTER_NUMBER = "Enter a number, or type '" + InputUtils.EXIT + "' to quit.";
    private static final String YOUR_NUMBER_WAS = "You number was ";
    private static final String EVEN = "even";
    private static final String ODD = "odd";
    private static final String PERIOD = ".";

    private final Scanner sc;

    public OddOrEven() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(ENTER_NUMBER);
            System.out.println(YOUR_NUMBER_WAS + (InputUtils.getInputDouble(sc, (Double d) -> true) % 2 == 0 ? EVEN : ODD) + PERIOD);
        }
    }
}
