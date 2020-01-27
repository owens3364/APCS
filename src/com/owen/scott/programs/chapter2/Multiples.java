package com.owen.scott.programs.chapter2;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class Multiples implements Runnable {
    private static final String ENTER = "Enter the ";
    private static final String NUMBER_OR_QUIT = " number, or type '" + InputUtils.EXIT + "' to quit.";
    private static final String FIRST = "first";
    private static final String SECOND = "second";
    private static final String FIRST_NUMBER = "The first number is ";
    private static final String NOT = "not ";
    private static final String MULTIPLE_OF_SECOND = "a multiple of the second number.";
    private final Scanner sc;

    public Multiples() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(ENTER + FIRST + NUMBER_OR_QUIT);
            double num1 = InputUtils.getInputDouble(sc, (Double d) -> true);
            System.out.println(ENTER + SECOND + NUMBER_OR_QUIT);
            double num2 = InputUtils.getInputDouble(sc, (Double d) -> d != 0);
            System.out.println(FIRST_NUMBER + (num1 % num2 == 0 ? "" : NOT) + MULTIPLE_OF_SECOND);
        }
    }
}
