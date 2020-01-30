package com.owen.scott.programs.chapter18;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

@Completed
public class MinimumValueInArray implements Runnable {
    private final Scanner sc;

    public MinimumValueInArray() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Enter the length of the array.");
            int arrayLength = InputUtils.getInputInt(sc, (Integer in) -> in > 0);
            double[] arr = new double[arrayLength];
            System.out.println("Enter all the numeric values of the array.");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = InputUtils.getInputDouble(sc, (Double d) -> true);
            }
            Arrays.sort(arr);
            System.out.println("The smallest value is: " + arr[0]);
        }
    }
}
