package com.owen.scott.programs.chapter6;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Completed
public class ParkingCharges implements Runnable {
    private static final byte MIN = 0x0;
    private static final double COST_PER_HOUR = 0.5;
    private static final byte MAX = 0xA;

    private final Scanner sc;

    public ParkingCharges() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter the number of hours each customer parked.\nEnter the first customer's hours, press return, and repeat until done.\nEnter '0' and press return to calculate results.");
        List<Double> hoursList = new LinkedList<>();
        while (true) {
            double hours = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
            if (hours == 0) break;
            hoursList.add(hours);
        }
        for (int i = 0; i < hoursList.size(); i++) {
            System.out.println("Customer " + (i + 1) + " owes " + calculateCharges(hoursList.get(i)));
        }

    }

    private double calculateCharges(double hoursParked) {
        if (hoursParked >= 19) {
            return 10;
        }
        if (hoursParked > 0 && hoursParked <= 3) {
            return 2;
        }
        return 2 + (Math.ceil(hoursParked - 3) * COST_PER_HOUR);
    }
}
