package com.owen.scott.programs.friday.builds.build4;

import com.owen.scott.annotations.Completed;

@Completed
public class FizzBuzz implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                System.out.println(i);
            } else if (i % 3 == 0 && i % 5 != 0) {
                System.out.println("GO");
            } else if (i % 3 != 0) {
                System.out.println("WARRIORS");
            } else {
                System.out.println("GO WARRIORS");
            }
        }
    }
}
