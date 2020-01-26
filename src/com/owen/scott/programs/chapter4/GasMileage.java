package com.owen.scott.programs.chapter4;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;
import com.owen.scott.programs.commons.Tuple;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

@Completed
public class GasMileage implements Runnable {
    private final Scanner sc;

    public GasMileage() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        List<Tuple<Double, Double>> trips = new LinkedList<>();

        while (true) {
            System.out.println("Enter trip length in miles, or '-1' to stop entry.");
            double tripLength = InputUtils.getInputDouble(sc, (Double d) -> d >= 0 || d == -1);
            if (tripLength == -1) break;
            System.out.println("Enter gas used for trip in gallons, or '-1' to stop entry.");
            double gallonsUsed = InputUtils.getInputDouble(sc, (Double d) -> d >= 0 || d == -1);
            if (gallonsUsed == -1) break;
            trips.add(new Tuple<>(tripLength, gallonsUsed));
        }

        System.out.println("MPG Per Trip");
        trips.forEach((Tuple<Double, Double> tuple) -> System.out.println(tuple.getA() / tuple.getB()));

        System.out.print("Overall MPG: ");
        AtomicReference<Double> tripLengthTotal = new AtomicReference<>((double) 0);
        AtomicReference<Double> gallonsUsedTotal = new AtomicReference<>((double) 0);
        trips.forEach((Tuple<Double, Double> tuple) -> {
            tripLengthTotal.updateAndGet(v -> v + tuple.getA());
            gallonsUsedTotal.updateAndGet(v -> v + tuple.getB());
        });
        System.out.println(tripLengthTotal.get() / gallonsUsedTotal.get());
    }
}
