package com.owen.scott.programs.chapter6;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class TemperatureConversions implements Runnable {
    private static final float CONVERSION_MULTIPLIER = 1.8f;
    private static final double CONVERSION_DIFFERENCE = 32;

    private final Scanner sc;

    public TemperatureConversions() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Type 'C' for Fahrenheit to Celsius or type 'F' for Celsius to Fahrenheit or type '" + InputUtils.EXIT + "' to quit.");
            String mode = InputUtils.getInputString(sc, (String str) -> str.equalsIgnoreCase("C") || str.equalsIgnoreCase("F") || str.equalsIgnoreCase(InputUtils.EXIT));
            if (mode.equalsIgnoreCase(InputUtils.EXIT)) break;
            System.out.println("Enter a temperature.");
            double temp = InputUtils.getInputDouble(sc, (Double d) -> true);
            if (mode.equalsIgnoreCase("F")) System.out.println("Celsius: " + toCelsius(temp));
            if (mode.equalsIgnoreCase("C")) System.out.println("Fahrenheit: " + toFahrenheit(temp));
        }
    }

    private double toCelsius(double degreesF) {
        return (degreesF - CONVERSION_DIFFERENCE) / CONVERSION_MULTIPLIER;
    }

    private double toFahrenheit(double degreesC) {
        return (CONVERSION_MULTIPLIER * degreesC) + CONVERSION_DIFFERENCE;
    }
}
