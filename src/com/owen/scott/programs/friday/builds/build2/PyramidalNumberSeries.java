package com.owen.scott.programs.friday.builds.build2;

import java.util.List;

public class PyramidalNumberSeries implements NumberSeries {
    @Override
    public List<Integer> getSeries(int length) {
        return null;
    }
   int pentagon_pyrimidal (int n)
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
