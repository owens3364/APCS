package com.owen.scott.programs.friday.builds.build2;

import com.owen.scott.annotations.InProgress;

import java.util.List;

@InProgress
public class Executor implements Runnable {
    @Override
    public void run() {
        NumberSeries fibonacciSeries = new FibonacciNumberSeries();
        NumberSeries pyramidalSeries = new PyramidalNumberSeries();
        NumberSeries triangularSeries = new TriangularNumberSeries();
        System.out.println(formatIntList(fibonacciSeries.getSeries(15)));
        //System.out.println(formatIntList(pyramidalSeries.getSeries(15)));
        System.out.println(formatIntList(triangularSeries.getSeries(15)));
    }

    private String formatIntList(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        list.forEach((Integer in) -> {
            sb.append(in);
            sb.append(", ");
        });
        return sb.toString().substring(0, sb.length() - 2);
    }
}
