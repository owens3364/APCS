package com.owen.scott.programs.commons;

import java.util.Scanner;

public class InputUtils {
    public static final String EXIT = "Exit";
    private static final String INPUT_INVALID = "Input invalid, please try again.";
    private static final String EXITING = "Exiting . . .";
    private static final byte SUCCESSFUL_EXIT_CODE = 0x0;

    public static double getInput(Scanner sc) {
        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                double in = sc.nextDouble();
                sc.nextLine();
                return in;
            }
            String nl = sc.nextLine();
            if (nl.equalsIgnoreCase(EXIT)) {
                System.out.println(EXITING);
                System.exit(SUCCESSFUL_EXIT_CODE);
            } else {
                System.out.println(INPUT_INVALID);
            }
        }
        return 0;
    }
}
