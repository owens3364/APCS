package com.owen.scott.programs.commons;

import java.util.Scanner;
import java.util.function.Function;

public class InputUtils {
    public static final String EXIT = "Exit";
    private static final String INPUT_INVALID = "Input invalid, please try again.";
    private static final String EXITING = "Exiting . . .";
    private static final byte SUCCESSFUL_EXIT_CODE = 0x0;

    public static String getInputString(Scanner sc, Function<String, Boolean> validator) {
        while (sc.hasNext()) {
            if (sc.hasNextLine()) {
                String in = sc.nextLine();
                if (validator.apply(in)) {
                    return in;
                }
            }
            System.out.println(INPUT_INVALID);
        }
        return "";
    }

    public static double getInputDouble(Scanner sc, Function<Double, Boolean> validator) {
        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                double in = sc.nextDouble();
                if (validator.apply(in)) {
                    sc.nextLine();
                    return in;
                }
            }
            cleanupBadInput(sc);
        }
        return 0;
    }

    public static int getInputInt(Scanner sc, Function<Integer, Boolean> validator) {
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int in = sc.nextInt();
                if (validator.apply(in)) {
                    sc.nextLine();
                    return in;
                }
            }
            cleanupBadInput(sc);
        }
        return 0;
    }

    private static void cleanupBadInput(Scanner sc) {
        String nl = sc.nextLine();
        if (nl.equalsIgnoreCase(EXIT)) {
            System.out.println(EXITING);
            System.exit(SUCCESSFUL_EXIT_CODE);
        } else {
            System.out.println(INPUT_INVALID);
        }
    }
}
