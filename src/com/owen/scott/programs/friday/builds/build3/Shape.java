package com.owen.scott.programs.friday.builds.build3;

import com.owen.scott.programs.commons.InputUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public enum Shape {
    CIRCLE, RECTANGLE, TRAPEZOID, REGULAR_HEXAGON;

    double getArea(double ... args) {
        switch (this) {
            case CIRCLE:
                return Math.pow(args[0], 2) * Math.PI;
            case RECTANGLE:
                return args[0] * args[1];
            case TRAPEZOID:
                return ((args[0] + args[1]) / 2) * args[2];
            case REGULAR_HEXAGON:
                return ((3 * Math.sqrt(3)) / 2) * Math.pow(args[0], 2);
        }
        return 0;
    }

    double[] getArguments(Scanner sc) {
        switch (this) {
            case CIRCLE:
                System.out.println("Enter the radius of the circle.");
                return new double[] {InputUtils.getInputDouble(sc, (Double d) -> d >= 0)};
            case RECTANGLE:
                System.out.println("Enter the width of the rectangle.");
                double rectangleWidth = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
                System.out.println("Enter the height of the rectangle.");
                double rectangleHeight = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
                return new double[] {rectangleWidth, rectangleHeight};
            case TRAPEZOID:
                System.out.println("Enter the length of the first base (one of the parallel lines).");
                double base1 = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
                System.out.println("Enter the length of the second base (the other parallel line).");
                double base2 = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
                System.out.println("Enter the height of the trapezoid (the shortest distance between the parallel lines).");
                double height = InputUtils.getInputDouble(sc, (Double d) -> d >= 0);
                return new double[] {base1, base2, height};
            case REGULAR_HEXAGON:
                System.out.println("Enter the length of one side.");
                return new double[] {InputUtils.getInputDouble(sc, (Double d) -> d >= 0)};
        }
        return new double[0];
    }

    static List<String> names() {
        List<String> names = new LinkedList<>();
        for (Shape value : Shape.values()) {
            names.add(value.name());
        }
        return names;
    }
}
