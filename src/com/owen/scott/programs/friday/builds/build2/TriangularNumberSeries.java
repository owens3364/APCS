package com.owen.scott.programs.friday.builds.build2;

import java.util.LinkedList;
import java.util.List;

public class TriangularNumberSeries implements NumberSeries {
    @Override
    public List<Integer> getSeries(int length) {
        return triangularNumberSeries(new LinkedList<>(), length).subList(0, length);
    }

    private List<Integer> triangularNumberSeries(List<Integer> start, int length) {
        if (length == 0) return start;
        int next;
        if (start.size() == 0) {
            next = 0;
        } else {
            next = start.get(Math.max(0, start.size() - 1)) + start.size();
        }
        start.add(next);
        start.add(triangularNumberSeries(start, length - 1).get(start.size() - 1));
        return start;
    }
}
