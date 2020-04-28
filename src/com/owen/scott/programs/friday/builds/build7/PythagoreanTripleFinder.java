package com.owen.scott.programs.friday.builds.build7;

import com.owen.scott.annotations.Completed;

@Completed
public class PythagoreanTripleFinder implements Runnable {
    private static final int MAX = 500;

    @Override
    public void run() {
        System.out.println("A\tB\tSUM");
        for (int a = 1; a < MAX; a++) {
            for (int b  = 1; b < MAX; b++) {
                for (int c = 1; c < MAX; c++) {
                    if (a < b && b < c && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
                        System.out.println(a + "\t" + b + "\t" + c);
                    }
                }
            }
        }
    }
}
