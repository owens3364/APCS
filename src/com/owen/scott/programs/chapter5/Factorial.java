package com.owen.scott.programs.chapter5;

import com.owen.scott.annotations.Completed;

@Completed
public class Factorial implements Runnable {
    private static final byte[] factorials = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    @Override
    public void run() {
        for (byte factorial : factorials) {
            System.out.println("Factorial of\t" + factorial + "\tis:\t" + factorial(factorial));
        }
    }

    private long factorial(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
}
