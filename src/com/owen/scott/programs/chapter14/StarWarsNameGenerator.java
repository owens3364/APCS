package com.owen.scott.programs.chapter14;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.InputUtils;

import java.util.Scanner;

@Completed
public class StarWarsNameGenerator implements Runnable {
    private final Scanner sc;

    public StarWarsNameGenerator() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter your first name.");
        String firstName = InputUtils.getInputString(sc, (String name) -> name.length() > 0);
        System.out.println("Enter your last name.");
        String lastName = InputUtils.getInputString(sc, (String name) -> name.length() > 0);
        System.out.println("Enter your mom's maiden name.");
        String maidenName = InputUtils.getInputString(sc, (String name) -> name.length() > 0);
        System.out.println("Enter the city you were born in.");
        String city = InputUtils.getInputString(sc, (String name) -> name.length() > 0);

        String newFirstName = firstName.substring(0, Math.min(firstName.length(), 3)) +
                lastName.substring(0, Math.min(lastName.length(), 2));

        String newLastName = maidenName.substring(0, Math.min(maidenName.length(), 2)) +
                city.substring(0, Math.min(city.length(), 3));

        System.out.println("New first name: " + newFirstName);
        System.out.println("New last name: " + newLastName);

        System.out.println("Enter the name of the first car you owned.");
        String carName = InputUtils.getInputString(sc, (String name) -> name.length() > 0);
        System.out.println("Enter the name of the last medication you took.");
        String medicationName = InputUtils.getInputString(sc, (String name) -> name.length() > 0);

        StringBuffer nameAndTitle = new StringBuffer();
        nameAndTitle.append(new StringBuffer(lastName).reverse(), 0, Math.min(lastName.length(), 3));
        nameAndTitle.append(carName);
        nameAndTitle.append(" of ");
        nameAndTitle.append(medicationName);

        System.out.println("Honorific name and title: " + nameAndTitle.toString());
    }
}
