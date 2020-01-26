package com.owen.scott.programs.commons;

public class OutputUtils {
    public static void printData(TestableProperties ... properties) {
        for (int i = 0; i < properties.length; i++) {
            System.out.println("Instance number: " + (i + 1));
            printData(properties[i]);
        }
    }

    public static void printData(TestableProperties properties) {
        properties.getProperties().forEach((String key, Object value) -> {
            System.out.println(key + ": " + (value != null ? value.toString() : ""));
        });
    }
}
