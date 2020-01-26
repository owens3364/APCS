package com.owen.scott.programs.chapter2;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class NegativePositiveZeroValues implements Runnable {
    private static final String ENTER_NUMBERS = "Enter 5 numbers, or type '" + InputUtils.EXIT + "' to quit.";
    private static final String QOF = "Quantity of ";
    private static final String POS = "positive";
    private static final String NEG = "negative";
    private static final String ZERO_VAL = "zero-value";
    private static final String NUMS = " numbers: ";
    private static final String QT_POS = QOF + POS + NUMS;
    private static final String QT_NEG = QOF + NEG + NUMS;
    private static final String QT_ZERO = QOF + ZERO_VAL + NUMS;
    private final Scanner sc;

    public NegativePositiveZeroValues() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            double[] entries = new double[5];
            byte posCount = 0;
            byte negCount = 0;
            byte zeroCount = 0;
            System.out.println(ENTER_NUMBERS);
            for (int i = 0; i < entries.length; i++) {
                entries[i] = InputUtils.getInputDouble(sc, (Double d) -> true);
                if (entries[i] > 0) posCount++;
                else if (entries[i] < 0) negCount++;
                else zeroCount++;
            }
            System.out.println(QT_POS + posCount);
            System.out.println(QT_NEG + negCount);
            System.out.println(QT_ZERO + zeroCount);
        }
    }
}
