package com.owen.scott.programs.chapter4;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

@Completed
public class SalesCommissionCalculator implements Runnable {
    private static final double ITEM_1_PRICE = 239.99;
    private static final double ITEM_2_PRICE = 129.75;
    private static final double ITEM_3_PRICE = 99.95;
    private static final double ITEM_4_PRICE = 350.89;

    private static final double INITIAL_EARNINGS = 200;
    private static final double COMMISSION = 0.09;

    private final Scanner sc;

    public SalesCommissionCalculator() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter all items sold this week ('1' for item 1, '2' for item 2, and so on). Enter '-1' to complete entry.");
        List<Integer> items = new LinkedList<>();
        while (true) {
            int item = InputUtils.getInputInt(sc, (Integer in) -> in > 0 && in < 5 || in == -1);
            if (item == -1) break;
            items.add(item);
        }
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        items.forEach((Integer item) -> {
            switch (item) {
                case 1:
                    sum.updateAndGet((Double d) -> d + ITEM_1_PRICE);
                    break;
                case 2:
                    sum.updateAndGet((Double d) -> d + ITEM_2_PRICE);
                    break;
                case 3:
                    sum.updateAndGet((Double d) -> d + ITEM_3_PRICE);
                    break;
                case 4:
                    sum.updateAndGet((Double d) -> d + ITEM_4_PRICE);
                    break;
            }
        });
        System.out.println("Total earnings for this week are: " + (INITIAL_EARNINGS + (sum.get() * COMMISSION)));
    }
}
