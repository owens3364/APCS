package com.owen.scott.programs.chapter6;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class Exponentiation implements Runnable {
    private final Scanner sc;

    public Exponentiation() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter the base number.");
        double base = InputUtils.getInputDouble(sc, (Double d) -> true);
        System.out.println("Enter the exponent as an integer.");
        int exponent = InputUtils.getInputInt(sc, (Integer i) -> i >= 0);
        System.out.println(exponent(base, exponent));
    }

    private double exponent(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        return base * exponent(base, exponent - 1);
    }
}
