package com.owen.scott.programs.chapter2;

import com.owen.scott.annotations.Completed;

import java.util.Scanner;

@Completed
public class OddOrEven implements Runnable {
    private static final String EXIT = "Exit";
    private static final String ENTER_NUMBER = "Enter a number, or type '" + EXIT + "' to quit.";
    private static final String YOUR_NUMBER_WAS = "You number was ";
    private static final String EVEN = "even";
    private static final String ODD = "odd";
    private static final String PERIOD = ".";
    private static final String INPUT_INVALID = "Input invalid, please try again.";
    private static final byte SUCCESSFUL_EXIT_CODE = 0x0;

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            System.out.println(ENTER_NUMBER);
            System.out.println(YOUR_NUMBER_WAS + (getInput() % 2 == 0 ? EVEN : ODD) + PERIOD);
        }
    }

    private double getInput() {
        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            }
            String nl = sc.nextLine();
            if (nl.equalsIgnoreCase(EXIT)) {
                System.exit(SUCCESSFUL_EXIT_CODE);
            } else {
                System.out.println(INPUT_INVALID);
            }
        }
        return 0;
    }
}
