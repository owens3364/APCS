package com.owen.scott.programs.chapter19;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

@Completed
public class BubbleSort implements Runnable {
    private final Scanner sc;

    public BubbleSort() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter the length of the array.");
        int arrayLength = InputUtils.getInputInt(sc, (Integer in) -> in > 0);
        double[] arr = new double[arrayLength];
        System.out.println("Enter all the numeric values of the array.");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = InputUtils.getInputDouble(sc, (Double d) -> true);
        }
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    private double[] bubbleSort(double[] arr) {
        boolean sorted = false;
        while (!sorted) {
            boolean changeMade = false;
            for (int i = 0; i < arr.length; i++) {
                if (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i + 1] = temp;
                    changeMade = true;
                }
            }
            if (!changeMade) sorted = true;
        }
        return arr;
    }
}
