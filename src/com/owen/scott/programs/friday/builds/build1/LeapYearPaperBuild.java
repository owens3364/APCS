package com.owen.scott.programs.friday.builds.build1;

import com.owen.scott.annotations.Completed;

import java.util.Scanner;

@Completed
public class LeapYearPaperBuild implements Runnable {
    private final Scanner sc;

    public LeapYearPaperBuild() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        double year1, year2, year3;
        System.out.println("Enter the first year. Do not include characters other than [0-9].");
        year1 = sc.nextDouble();
        System.out.println("Enter the second year. Do not include characters other than [0-9]");
        year2 = sc.nextDouble();
        System.out.println("Enter the third year. Do not include characters other than [0-9]");
        year3 = sc.nextDouble();
        System.out.println(year1 + " is" + (!leapYear(year1) ? " not" : "") + " a leap year.");
        System.out.println(year2 + " is" + (!leapYear(year2) ? " not" : "") + " a leap year.");
        System.out.println(year3 + " is" + (!leapYear(year3) ? " not" : "") + " a leap year.");
    }

    private boolean leapYear(double year) {
        if (year % 4 == 0) {
            return !(year % 100 == 0 && year % 400 != 0);
        }
        return false;
    }
}