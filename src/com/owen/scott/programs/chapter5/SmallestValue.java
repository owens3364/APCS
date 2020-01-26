package com.owen.scott.programs.chapter5;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class SmallestValue implements Runnable {
    private final Scanner sc;

    public SmallestValue() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter length of list of integers.");
        int length = InputUtils.getInputInt(sc, (Integer in) -> true);
        int[] integers = new int[length];
        System.out.println("Begin entering integers.");
        for (int i = 0; i < integers.length; i++) {
            integers[i] = InputUtils.getInputInt(sc, (Integer in) -> true);
        }
        System.out.println("The smallest value is: " + smallestValue(integers));
    }

    private int smallestValue(int[] integers) {
        int small = Integer.MAX_VALUE;
        for (int integer : integers) {
            if (integer < small) {
                small = integer;
            }
        }
        return small;
    }
}
