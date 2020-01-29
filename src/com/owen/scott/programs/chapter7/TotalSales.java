package com.owen.scott.programs.chapter7;

import com.owen.scott.annotations.InProgress;
import com.owen.scott.programs.commons.InputUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@InProgress
public class TotalSales implements Runnable {
    private final Scanner sc;

    private double product1Cost, product2Cost, product3Cost, product4Cost, product5Cost;

    public TotalSales() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        getProductCosts();
        List<Slip> slips = getSlips();
        Map<Integer, List<Integer>> slipsTable = new HashMap<>();
        slips.forEach((Slip slip) -> slipsTable.put(slip.getSalesPersonNumber(), new LinkedList<>()));
        slips.forEach((Slip slip) -> Optional.of(slipsTable.get(slip.getSalesPersonNumber())).ifPresent((List<Integer> productNumbers) -> productNumbers.add(slip.getProductNumber())));
        slipsTable.forEach((Integer employeeNumber, List<Integer> employeeSales) -> {
            StringBuffer sb = new StringBuffer();
            employeeSales.forEach((Integer in) -> {
                sb.append(in);
                sb.append(", ");
            });
            System.out.println("Employee #" + employeeNumber + ": " + sb.toString().substring(0, sb.length() - 2));
        });
        System.out.println("Sales by employee");
        slipsTable.forEach((Integer employeeNumber, List<Integer> employeeSales) -> System.out.println("Employee #" + employeeNumber + ": " + sum(employeeSales)));
        System.out.println("Sales by product type");
        AtomicReference<Double> product1Count = new AtomicReference<>((double) 0);
        AtomicReference<Double> product2Count = new AtomicReference<>((double) 0);
        AtomicReference<Double> product3Count = new AtomicReference<>((double) 0);
        AtomicReference<Double> product4Count = new AtomicReference<>((double) 0);
        AtomicReference<Double> product5Count = new AtomicReference<>((double) 0);
        slipsTable.forEach((Integer employeeNumber, List<Integer> employeeSales) -> employeeSales.forEach((Integer in) -> {
            switch (in) {
                case 1:
                    product1Count.getAndSet(product1Count.get() + 1);
                    break;
                case 2:
                    product2Count.getAndSet(product2Count.get() + 1);
                    break;
                case 3:
                    product3Count.getAndSet(product3Count.get() + 1);
                    break;
                case 4:
                    product4Count.getAndSet(product4Count.get() + 1);
                    break;
                case 5:
                    product5Count.getAndSet(product5Count.get() + 1);
                    break;
            }
        }));
        System.out.println("Product 1 total: " + product1Count.get());
        System.out.println("Product 2 total: " + product2Count.get());
        System.out.println("Product 3 total: " + product3Count.get());
        System.out.println("Product 4 total: " + product4Count.get());
        System.out.println("Product 5 total: " + product5Count.get());

        System.out.println("Product 1 total sales: " + product1Count.get() * product1Cost);
        System.out.println("Product 2 total sales: " + product2Count.get() * product2Cost);
        System.out.println("Product 3 total sales: " + product3Count.get() * product3Cost);
        System.out.println("Product 4 total sales: " + product4Count.get() * product4Cost);
        System.out.println("Product 5 total sales: " + product5Count.get() * product5Cost);
    }

    private List<Slip> getSlips() {
        System.out.println("Begin entering slips.");
        List<Slip> slips = new LinkedList<>();
        boolean done = false;
        while (!done) {
            System.out.println("Enter employee number (1-4).");
            int salesPersonNumber = InputUtils.getInputInt(sc, (Integer in) -> in > 0 && in < 5);
            System.out.println("Enter product number (1-5).");
            int productNumber = InputUtils.getInputInt(sc, (Integer in) -> in > 0 && in < 6);
            slips.add(new Slip(salesPersonNumber, productNumber));
            System.out.println("Is this the last slip (y/n)?");
            done = InputUtils.getInputString(sc, (String str) -> str.equalsIgnoreCase("y") || str.equalsIgnoreCase("n")).equalsIgnoreCase("y");
        }
        return slips;
    }

    private void getProductCosts() {
        System.out.println("Enter cost of item 1.");
        product1Cost = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
        System.out.println("Enter cost of item 2.");
        product2Cost = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
        System.out.println("Enter cost of item 3.");
        product3Cost = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
        System.out.println("Enter cost of item 4.");
        product4Cost = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
        System.out.println("Enter cost of item 5.");
        product5Cost = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
    }

    private double sum(List<Integer> ints) {
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        ints.forEach((Integer in) -> {
            switch (in) {
                case 1:
                    sum.updateAndGet(v -> v + product1Cost);
                    break;
                case 2:
                    sum.updateAndGet(v -> v + product2Cost);
                    break;
                case 3:
                    sum.updateAndGet(v -> v + product3Cost);
                    break;
                case 4:
                    sum.updateAndGet(v -> v + product4Cost);
                    break;
                case 5:
                    sum.updateAndGet(v -> v + product5Cost);
                    break;
            }
        });
        return sum.get();
    }
}
