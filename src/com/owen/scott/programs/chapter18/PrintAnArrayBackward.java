package com.owen.scott.programs.chapter18;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

@Completed
public class PrintAnArrayBackward implements Runnable {
    private final Scanner sc;

    public PrintAnArrayBackward() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Enter a string value to see it printed backwards. Enter '!' to quit.");
            String val = InputUtils.getInputString(sc, (String str) -> true);
            if (val.equalsIgnoreCase("!")) break;
            System.out.println(stringReverse(val.toCharArray()));
        }
    }

    private String stringReverse(char[] arr) {
        if (arr.length > 0) {
            return arr[arr.length - 1] + stringReverse(Arrays.copyOfRange(arr, 0, arr.length - 1));
        }
        return "";
    }
}
