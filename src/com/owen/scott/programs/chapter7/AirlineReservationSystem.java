package com.owen.scott.programs.chapter7;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

@Completed
public class AirlineReservationSystem implements Runnable {
    private static final byte PLANE_SEATS = 0xA;
    private static final byte FIRST_CLASS_CAP = PLANE_SEATS / 2;
    private static final byte ECONOMY_CAP = PLANE_SEATS;
    private static final String AIRLINE_PREFIX = "BU";
    private static final String GATE = "A1";

    private final Scanner sc;

    public AirlineReservationSystem() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        boolean[] seats = new boolean[10];
        Arrays.fill(seats, false);
        boolean full = false;
        while (true) {
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
            if (!full) {
                boolean seatFound = false;
                int seatNumber = 0;
                while (!seatFound) {
                    for (int i = flightType == 1 ? 0 : 5; i < (flightType == 1 ? FIRST_CLASS_CAP : ECONOMY_CAP); i++) {
                        if (!seats[i]) {
                            seatNumber = i + 1;
                            seats[i] = true;
                            seatFound = true;
                            break;
                        }
                    }
                    if (!seatFound) {
                        System.out.println("Please select another boarding class.");
                        final int finalFlightType = flightType;
                        flightType = InputUtils.getInputInt(sc, (Integer in) -> in == (finalFlightType == 1 ? 2 : 1));
                    }
                }
                System.out.println("Name:\t" + name);
                System.out.println("From:\t" + departureAirport);
                System.out.println("To:\t\t" + destinationAirport);
                System.out.println("Flight:\t" + AIRLINE_PREFIX + flightNumber);
                System.out.println("Time:\t" + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").format(LocalDateTime.now()));
                System.out.println("Gate:\t" + GATE);
                System.out.println("Boarding till:\t" + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").format(LocalDateTime.now().minusMinutes(30)));
                System.out.println("Seat:\t" + seatNumber);
                full = true;
                for (boolean seat : seats) {
                    if (!seat) {
                        full = false;
                        break;
                    }
                }
            } else {
                System.out.println("Next flight leaves in 3 hours.");
            }
        }
    }

    private String format(int num) {
        if (num < 10) return "000" + num;
        if (num < 100) return "00" + num;
        if (num < 1000) return "0" + num;
        return String.valueOf(num);
    }
}
