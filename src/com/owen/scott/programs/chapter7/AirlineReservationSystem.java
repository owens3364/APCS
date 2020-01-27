package com.owen.scott.programs.chapter7;

import com.owen.scott.annotations.InProgress;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@InProgress
public class AirlineReservationSystem implements Runnable {
    private static final byte PLANE_SEATS = 0xA;
    private static final byte FIRST_CLASS_CAP = PLANE_SEATS / 2 - 1;
    private static final byte ECONOMY_CAP = PLANE_SEATS - 1;
    private static final String GATE = "A1";

    private final Scanner sc;

    public AirlineReservationSystem() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        boolean[] seats = new boolean[10];
        boolean full = false;
        while (!full) {
            System.out.println("Please enter your name.");
            String name = InputUtils.getInputString(sc, (String str) -> true);
            System.out.println("Please enter your departure.");
            String departureAirport = InputUtils.getInputString(sc, (String str) -> true);
            System.out.println("Please enter your destination.");
            String destinationAirport = InputUtils.getInputString(sc, (String str) -> true);
            System.out.println("Please enter your flight number. The 'Budget Airlines' BA prefix should be excluded.");
            String flightNumber = format(InputUtils.getInputInt(sc, (Integer in) -> in > -1 && in < 10000));
            System.out.println("Please type 1 for First Class or 2 for Economy.");
            int flightType = InputUtils.getInputInt(sc, (Integer in) -> in == 1 || in == 2);
            boolean seatFound = false;
            for (int i = flightType == 1 ? 0 : 5; i < (flightType == 1 ? FIRST_CLASS_CAP : ECONOMY_CAP); i++) {
                if (!seats[i]) {
                    seatFound = true;
                    break;
                }
            }
            //if (!seatFound)
        }
    }

    private String format(int num) {
        if (num < 10) return "000" + num;
        if (num < 100) return "00" + num;
        if (num < 1000) return "0" + num;
        return String.valueOf(num);
    }
}
