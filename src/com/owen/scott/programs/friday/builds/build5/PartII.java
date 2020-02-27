package com.owen.scott.programs.friday.builds.build5;

import com.owen.scott.annotations.Completed;

@Completed
public class PartII implements Runnable {
    @Override
    public void run() {
        int  i = 10;
        while (i < 57) {
            while (i < 10) {}
            String strVal = String.valueOf(i);
            if (Integer.parseInt(String.valueOf(strVal.charAt(0))) + Integer.parseInt(String.valueOf(strVal.charAt(1))) > 10) {
                System.out.println(i);
            }
            i++;
        }
    }
}
