package com.owen.scott.programs.chapter2;

import com.owen.scott.annotations.Completed;

@Completed
public class SquaresAndCubesTable implements Runnable {

    @Override
    public void run() {
        System.out.println("Number\tSquare\tCube");
        for (int i = 0; i < 11; i++) {
            System.out.println(i + "\t\t" + i * i + "\t\t" + i * i * i);
        }
    }
}
