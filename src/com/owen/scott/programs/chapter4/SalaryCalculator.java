package com.owen.scott.programs.chapter4;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;
import com.owen.scott.programs.commons.Triplet;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Completed
public class SalaryCalculator implements Runnable {
    private final Scanner sc;

    public SalaryCalculator() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        List<Triplet<String, Double, Double>> chart = new LinkedList<>();
        while (true) {
            System.out.println("Enter an employee name, or type '!' to stop entry.");
            String name = InputUtils.getInputString(sc, (String str) -> true);
            if (name.equalsIgnoreCase("!")) break;
            System.out.println("Enter the employee's hourly rate.");
            double rate = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
            System.out.println("Enter the employee's hours worked last week.");
            double hours = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
            chart.add(new Triplet<>(name, rate, hours));
        }
        chart.forEach((Triplet<String, Double, Double> employee) -> {
            System.out.println(employee.getA() + "'" + (employee.getA().endsWith("s") ? "" : "s") + " Gross pay: " + ((employee.getB() * employee.getC()) + (employee.getC() > 40 ? (employee.getB() * (employee.getC() - 40) * .5) : 1)));
        });
    }
}
