package com.owen.scott.programs.chapter18;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class Palindromes implements Runnable {
    private final Scanner sc;

    public Palindromes() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Enter a string or phrase to check if it's a palindrome. Enter '!' to quit.");
            String val = InputUtils.getInputString(sc, (String str) -> true);
            if (val.equalsIgnoreCase("!")) break;
            System.out.println(val + " is" + (!palindrome(val.replaceAll("[^a-zA-Z\\s+]", "").toLowerCase()) ? " not" : "") + " a palindrome.");
        }
    }

    private boolean palindrome(String val) {
        if (val.length() == 1) return true;
        if (val.length() == 2 && val.charAt(0) == val.charAt(1)) return true;
        return val.charAt(0) == val.charAt(val.length() - 1) && palindrome(val.substring(1, val.length() - 1));
    }
}
