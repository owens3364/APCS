package com.owen.scott.programs.friday.builds.build2;

import java.util.LinkedList;
import java.util.List;

public class PyramidalNumberSeries implements NumberSeries {
    @Override
    public List<Integer> getSeries(int length) {
        List<Integer> series = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            series.add(pentagonPyrimidal(i));
        }
        return series;
    }

   int pentagonPyrimidal (int n)
   {
       int sum = 0;
       //run loop from 1 to n
       for (int i = 1; i <= n; i++)
       {
           //get nth pentagonal number
           int p = (3 * i * i - i) /2;
           //add to sum
           sum = sum +p;
       }
       return sum;
   }
}
