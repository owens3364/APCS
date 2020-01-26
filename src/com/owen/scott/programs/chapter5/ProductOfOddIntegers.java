package com.owen.scott.programs.chapter5;

import com.owen.scott.annotations.Completed;

@Completed
public class ProductOfOddIntegers implements Runnable {
    @Override
    public void run() {
        System.out.println(productOfOddIntegers(2, 15));
    }

    // Range includes start and end
    private int productOfOddIntegers(int start, int end) {
        if (start  > end) {
            throw new IllegalArgumentException("Start value must not be greater than the end value.");
        }
        if (start == end) return 0;
        int[] integers = new int[(end - start) + 1];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = i + start;
        }
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0) integers[i] = 1;
        }
        int product = 1;
        for (int integer : integers) {
            product *= integer;
        }
        return product;
    }
}
