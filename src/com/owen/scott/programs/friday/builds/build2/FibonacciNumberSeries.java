package com.owen.scott.programs.friday.builds.build2;

import java.util.LinkedList;
import java.util.List;

public class FibonacciNumberSeries implements NumberSeries {
    @Override
    public List<Integer> getSeries(int length) {
        return fibonacciNumberSeries(new LinkedList<>(), length).subList(0, length);
    }

    private List<Integer> fibonacciNumberSeries(List<Integer> start, int length) {
        if (length == 0) return start;
        if (start.size() == 0) {
            start.add(0);
        } else if (start.size() == 1){
            start.add(1);
        } else {
            start.add(start.get(start.size() - 2) + start.get(start.size() - 1));
        }
        start.add(fibonacciNumberSeries(start, length - 1).get(start.size() - 1));
        return start;
    }
}
