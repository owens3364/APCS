package com.owen.scott.programs.chapter6;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.security.SecureRandom;
import java.util.Scanner;

@Completed
public class ComputerAssistedInstruction implements Runnable {
    private static final byte UPPER_EXCLUSIVE_BOUND = 0xA;

    private final Scanner sc;
    private final SecureRandom numberGenerator;

    public ComputerAssistedInstruction() {
        sc = new Scanner(System.in);
        numberGenerator = new SecureRandom();
    }

    @Override
    public void run() {
        while (true) {
            double correctAnswer = askQuestionGetAnswer();
            boolean answered = false;
            while (!answered) {
                double userAnswer = InputUtils.getInputDouble(sc, (Double d) -> true);
                answered = userAnswer == correctAnswer;
                if (!answered) System.out.println("Incorrect. Please try again.");
                else System.out.println("Very good!");
            }
        }
    }

    private double askQuestionGetAnswer() {
        double multiple1 = numberGenerator.nextInt(UPPER_EXCLUSIVE_BOUND), multiple2 = numberGenerator.nextInt(UPPER_EXCLUSIVE_BOUND);
        System.out.println("What is " + multiple1 + " * " + multiple2 + "?");
        return multiple1 * multiple2;
    }
}
