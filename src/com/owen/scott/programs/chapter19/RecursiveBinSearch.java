package com.owen.scott.programs.chapter19;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

@Completed
public class RecursiveBinSearch implements Runnable {
    private final Scanner sc;

    public RecursiveBinSearch() {
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
        Arrays.sort(arr);
        System.out.println("Enter the value to be searched for.");
        double searchFor = InputUtils.getInputDouble(sc, (Double d) -> true);
        double position = binSearch(searchFor, arr);
        System.out.println(position == -1 ? "The element does not exist in the given array." : "The element has been found at element " + position + " of the given array (using a zero-indexed array).");
    }

    private int binSearch(double target, double[] arr) {
        switch (arr.length) {
            case 0: return -1;
            case 1: return arr[0] == target ? 0 : -1;
        }
        double pivot = arr[arr.length / 2];
        if (target == pivot) return arr.length / 2;
        if (target < pivot) {
            return binSearch(target, Arrays.copyOfRange(arr, 0, arr.length / 2));
        }
        return (arr.length / 2) + binSearch(target, Arrays.copyOfRange(arr, arr.length / 2, arr.length));
    }
}
