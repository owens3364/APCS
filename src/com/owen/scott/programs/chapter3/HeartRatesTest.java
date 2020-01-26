package com.owen.scott.programs.chapter3;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;
import com.owen.scott.programs.commons.OutputUtils;

import java.util.Scanner;

@Completed
public class HeartRatesTest implements Runnable {
    private static final byte MONTH_LOWER_LIMIT = 0x0;
    private static final byte MONTH_FEBRUARY = 0x2;
    private static final byte MONTH_UPPER_LIMIT = 0xD;
    private static final byte DAY_LOWER_LIMIT = 0x0;
    private static final byte DAY_UPPER_LIMIT = 0x1F;
    private static final byte FEBRUARY_LOWER_LIMIT = 0x1C;
    private static final byte FEBRUARY_UPPER_LIMIT = 0x1D;

    private final Scanner sc;

    public HeartRatesTest() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter your first name.");
        String first = InputUtils.getInputString(sc, (String str) -> !toString().equalsIgnoreCase(InputUtils.EXIT));
        System.out.println("Enter your last name.");
        String last = InputUtils.getInputString(sc, (String str) -> !toString().equalsIgnoreCase(InputUtils.EXIT));
        System.out.println("Enter the year you were born.");
        int year = InputUtils.getInputInt(sc, (Integer in) -> true);
        System.out.println("Enter the month you were born as a number between 1 and 12, inclusively.");
        int month = InputUtils.getInputInt(sc, (Integer in) -> in > MONTH_LOWER_LIMIT && in < MONTH_UPPER_LIMIT);
        System.out.println("Enter the day you were born as a number between 1 and 31, inclusively.");
        int day = InputUtils.getInputInt(sc, (Integer in) -> in > DAY_LOWER_LIMIT && in < (month == MONTH_FEBRUARY ? (isLeapYear(year) ? FEBRUARY_UPPER_LIMIT : FEBRUARY_LOWER_LIMIT) : DAY_UPPER_LIMIT));
        HeartRates hr = new HeartRates(first, last, day, month, year);
        OutputUtils.printData(hr);
    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }
}
