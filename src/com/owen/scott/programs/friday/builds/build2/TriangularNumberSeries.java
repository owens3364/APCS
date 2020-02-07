package com.owen.scott.programs.friday.builds.build2;

import java.util.LinkedList;
import java.util.List;

public class TriangularNumberSeries implements NumberSeries {
    @Override
    public List<Integer> getSeries(int length) {
        return null;
    }

    private List<Integer> triangularNumberSeries(List<Integer> start, int length) {
        if (length == 0) return start;
        start.addAll(triangularNumberSeries(start, length - 1));
    }
}
