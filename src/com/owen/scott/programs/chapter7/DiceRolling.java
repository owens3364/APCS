package com.owen.scott.programs.chapter7;

import com.owen.scott.annotations.Completed;

import java.util.Random;

@Completed
public class DiceRolling implements Runnable {
    private static final byte DICE_SIDES = 6;
    private static final int DICE_ROLLS = 36000000;

    private final Random random;

    public DiceRolling() {
        random = new Random();
    }

    @Override
    public void run() {
        int[] rollSumCounts = new int[11];
        int roll1, roll2;
        for (int i = 0; i < DICE_ROLLS; i++) {
            roll1 = random.nextInt(DICE_SIDES) + 1;
            roll2 = random.nextInt(DICE_SIDES) + 1;
            rollSumCounts[roll1 + roll2 - 2]++;
        }
        System.out.println("Sum\tFrequency");
        for (int i = 0; i < rollSumCounts.length; i++) {
            System.out.println((i + 2) + "\t" + rollSumCounts[i]);
        }
    }
}
