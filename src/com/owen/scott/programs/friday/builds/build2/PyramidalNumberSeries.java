package com.owen.scott.programs.friday.builds.build2;

import java.util.LinkedList;
import java.util.List;

public class PyramidalNumberSeries implements NumberSeries {
    @Override
    public List<Integer> getSeries(int length) {
        List<Integer> series = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            series.add(pentagonPyramidal(i));
        }
        return series;
    }

   int pentagonPyramidal(int n) {
       if (n == 0 || n == 1) return n;
       return (n * n) + pentagonPyramidal(n - 1);
   }
}
