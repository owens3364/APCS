package com.owen.scott.programs.chapter2;

import com.owen.scott.annotations.Completed;

@Completed
public class Checkerboard implements Runnable {
    private static final String ASTERISKS = "* * * * * * * *";

    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println((i % 2 == 0 ? "" : " ") + ASTERISKS);
        }
    }
}
