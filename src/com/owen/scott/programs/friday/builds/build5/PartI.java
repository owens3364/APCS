package com.owen.scott.programs.friday.builds.build5;

import com.owen.scott.annotations.Completed;

@Completed
public class PartI implements Runnable {
    @Override
    public void run() {
        for (int  i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(String.valueOf(i) + String.valueOf(j) + ", " + String.valueOf(i) + " + " + String.valueOf(j) + " = " + (i + j));
            }
        }
    }
}
