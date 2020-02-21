package com.owen.scott.programs.chapter2;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class BMICalc implements Runnable {
    private final Scanner sc;

    public BMICalc() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Follow the prompts, or type " + InputUtils.EXIT + " to quit.");
        while (true) {
            System.out.println("Enter your height in inches.");
            double height = InputUtils.getInputDouble(sc, (Double d) -> d > 0);
            System.out.println("Enter your weight in pounds.");
            double weight = InputUtils.getInputDouble(sc, (Double d) -> d > 0);
            System.out.println("BMI: " + ((weight * 703) / (height * height)));
            System.out.println("BMI VALUES");
            System.out.println("Underweight:\tless than 18.5");
            System.out.println("Normal:\t\t\tbetween 18.5 and 24.9");
            System.out.println("Overweight:\t\tbetween 25 and 29.9");
            System.out.println("Obese:\t\t\t30 or greater");
        }
    }
}
