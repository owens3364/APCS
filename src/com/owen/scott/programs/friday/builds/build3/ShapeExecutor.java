package com.owen.scott.programs.friday.builds.build3;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

@Completed
public class ShapeExecutor implements Runnable {
    private final Scanner sc;

    public ShapeExecutor() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter the kind of shape you'd like to find the area of.");
        System.out.println("Your options include: " + Arrays.toString(Shape.values()));
        String shapeType = InputUtils.getInputString(sc, (String str) -> Shape.names().contains(str.toUpperCase()));
        double area;
        if (shapeType.equalsIgnoreCase(Shape.CIRCLE.name())) {
            area = Shape.CIRCLE.getArea(Shape.CIRCLE.getArguments(sc));
        } else if (shapeType.equalsIgnoreCase(Shape.RECTANGLE.name())) {
            area = Shape.RECTANGLE.getArea(Shape.RECTANGLE.getArguments(sc));
        } else if (shapeType.equalsIgnoreCase(Shape.TRAPEZOID.name())) {
            area = Shape.TRAPEZOID.getArea(Shape.TRAPEZOID.getArguments(sc));
        } else {
            area = Shape.REGULAR_HEXAGON.getArea(Shape.REGULAR_HEXAGON.getArguments(sc));
        }
        System.out.println("Area: " + area);
    }
}
