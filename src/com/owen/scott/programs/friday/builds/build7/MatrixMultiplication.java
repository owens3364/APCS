package com.owen.scott.programs.friday.builds.build7;

import java.util.Arrays;

public class MatrixMultiplication {
    public static int[] matrixTimesVector(int[][] matrix, int[] vector) {
        if (validateMatrix(matrix) && vector != null && vector.length == matrix[0].length) {
            int[] result = new int[matrix.length];
            Arrays.fill(result, 0);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    result[i] += matrix[i][j] * vector[j];
                }
            }
            return result;
        } else {
            throw new IllegalArgumentException("Matrix must be rectangular and have non-null rows with at least one element each. Vector must be non-null and contain as many members as each row of the matrix.");
        }
    }

    public static boolean validateMatrix(int[][] matrix) {
        boolean valid = false;
        if (matrix.length > 0) {
            if (matrix[0].length > 0) {
                valid = true;
                for (int[] cols : matrix) {
                    if (cols == null || cols.length != matrix[0].length) {
                        valid = false;
                        break;
                    }
                }
            }
        }
        return valid;
    }
}
