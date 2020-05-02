package com.owen.scott.programs.friday.builds.build6;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

@Completed
public class PrimeNumberFinder implements Runnable {
    private final Scanner sc;

    public PrimeNumberFinder() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter the end of the range to find prime numbers in.");
        int primeCount = InputUtils.getInputInt(sc, (Integer in) -> in > -1);
        boolean[] primes = new boolean[primeCount];
        Arrays.fill(primes, true);
        for (int i = 2; i < primes.length; i++) {
            for (int j = 2; i * j < primeCount; j++) {
                primes[i * j] = false;
            }
        }
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) System.out.println(i);
        }
    }
}
