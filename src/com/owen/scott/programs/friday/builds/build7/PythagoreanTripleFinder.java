package com.owen.scott.programs.friday.builds.build7;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Completed
public class PythagoreanTripleFinder implements Runnable {
    private static final int MAX = 500;

    private static final int[] ORIGIN_VECTOR = {3, 4, 5};

    private static final int[][] NODE_1_MATRIX = {
            {-1, 2, 2},
            {-2, 1, 2},
            {-2, 2, 3},
    };

    private static final int[][] NODE_2_MATRIX = {
            {1, 2, 2},
            {2, 1, 2},
            {2, 2, 3},
    };

    private static final int[][] NODE_3_MATRIX = {
            {1, -2, 2},
            {2, -1, 2},
            {2, -2, 3},
    };

    private final Scanner sc;

    public PythagoreanTripleFinder() {
        sc = new Scanner(System.in);
    }

    private final PythagoreanTriple origin = new PythagoreanTriple();

    @Override
    public void run() {
        System.out.println("Here is a basic implementation of the pythagorean triple finder.");
        System.out.println("However, it is *extremely* inefficient, with a performance of O(n^3) that gets exponentially less successful at finding Pythagorean triples.");
        System.out.println("Basic implementation");
        System.out.println("A\tB\tSUM");
        first500TriplesByBruteForce();
        System.out.println("Please note that giving the following programs sufficiently large numbers will break them.");
        System.out.println("They were written primarily as an educational exercise and, while there is some level of validation, it isn't perfect.");
        System.out.println("The programs are implemented via ints and longs rather than BigIntegers.");
        System.out.println("Those would be a viable replacement, if I were willing to put in the effort to deal with them :)");
        System.out.println("Here is a program that creates Pythagorean triples based on multiples of the original Pythagorean triple (3, 4, 5).");
        System.out.println("It has a performance of O(n) which is significantly better than the brute force approach.");
        System.out.println("How many triples would you like to find?");
        triplesByMultiplesOfOrigin(InputUtils.getInputInt(sc, (Integer in) -> in > 0));
        System.out.println("Here is another program that uses matrix multiplication to find primitive Pythagorean triples, ie triples that have no common divisors across a, b, and c.");
        System.out.println("It also has O(n) performance, although its output is generally higher than requested. See the note below.");
        System.out.println("How many triples would you like to find?");
        System.out.println("Note: the program will almost always produce more triples than requested, because it is an infinite ternary tree and is terminated via a node-depth check.");
        primitiveTriples(InputUtils.getInputInt(sc, (Integer in) -> in > 0));
    }

    private void first500TriplesByBruteForce() {
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

    private void triplesByMultiplesOfOrigin(int multiples) {
        System.out.println("A\tB\tSUM");
        for (int i = 1; i < multiples + 1; i++) {
            System.out.println(origin.multipliedBy(i));
        }
    }

    private void primitiveTriples(int requested) {
        int maxRequiredNodeDepth = (int) Math.ceil(Math.log(requested) / Math.log(3));
        int nodeDepth = maxRequiredNodeDepth;
        int temp = 0;
        for (int i = 0; i < maxRequiredNodeDepth; i++) {
            temp += Math.pow(3, i);
            if (temp >= requested) {
                nodeDepth = i;
                break;
            }
        }
        List<int[]> primitiveTriples = new LinkedList<>();
        calculateTriples(primitiveTriples, nodeDepth, 0, ORIGIN_VECTOR);
        System.out.println(nodeDepth);
        System.out.println(primitiveTriples.size());
        System.out.println(origin);
        primitiveTriples.forEach((int[] triple) -> {
            if (triple != null && triple.length == 3) {
                System.out.println(new PythagoreanTriple(triple[0], triple[1], triple[2]));
            }
        });
    }

    private void calculateTriples(List<int[]> triples, int targetNodeDepth, int currentNodeDepth, int[] startingTriple) {
        if (currentNodeDepth < targetNodeDepth) {
            int[] triple1 = MatrixMultiplication.matrixTimesVector(NODE_1_MATRIX, startingTriple);
            int[] triple2 = MatrixMultiplication.matrixTimesVector(NODE_2_MATRIX, startingTriple);
            int[] triple3 = MatrixMultiplication.matrixTimesVector(NODE_3_MATRIX, startingTriple);
            triples.add(triple1);
            triples.add(triple2);
            triples.add(triple3);
            calculateTriples(triples, targetNodeDepth, currentNodeDepth + 1, triple1);
            calculateTriples(triples, targetNodeDepth, currentNodeDepth + 1, triple2);
            calculateTriples(triples, targetNodeDepth, currentNodeDepth + 1, triple3);
        }
    }
}
