package com.owen.scott.programs.chapter2;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class CircleProperties implements Runnable {
    private static final String ENTER_RAD = "Enter the radius of the circle, or type '" + InputUtils.EXIT + "' to quit.";
    private final Scanner sc;

    public CircleProperties() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(ENTER_RAD);
            double radius = InputUtils.getInputDouble(sc, (Double d) -> true);
            System.out.printf("Diameter: %f\n", radius * 2);
            System.out.printf("Circumference: %f\n", radius * Math.PI);
            System.out.printf("Area: %f\n", radius * radius * Math.PI);
        }
    }
}
