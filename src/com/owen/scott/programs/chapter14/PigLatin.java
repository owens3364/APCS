package com.owen.scott.programs.chapter14;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Completed
public class PigLatin implements Runnable {
    private final Scanner sc;

    private static final String SALT = "ay";

    public PigLatin() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Enter a phrase you'd like in pig latin, or type '!' to quit.");
            String english = InputUtils.getInputString(sc, (String str) -> true);
            if (english.equalsIgnoreCase("!")) break;
            System.out.println(encode(english));
        }
    }

    private String encode(String src) {
        List<String> phrases = Arrays.asList(src.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+"));
        List<String> pigLatin = new LinkedList<>();
        phrases.forEach((String str) -> {
            if (str.length() > 0) {
                pigLatin.add(str.substring(1) + str.charAt(0) + SALT);
            }
        });
        if (pigLatin.size() > 0) {
            if (pigLatin.get(0).length() > 1) {
                pigLatin.set(0, pigLatin.get(0).substring(0, 1).toUpperCase() + pigLatin.get(0).substring(1));
            } else {
                pigLatin.set(0, pigLatin.get(0).toUpperCase());
            }
        }
        StringBuilder phraseBuilder = new StringBuilder();
        pigLatin.forEach((String str) -> {
            phraseBuilder.append(str);
            phraseBuilder.append(" ");
        });
        return phraseBuilder.toString().trim() + ".";
    }
}
