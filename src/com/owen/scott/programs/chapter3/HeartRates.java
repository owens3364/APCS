package com.owen.scott.programs.chapter3;

import com.owen.scott.programs.commons.TestableProperties;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class HeartRates implements TestableProperties {
    private static final short MAX_HR_SRC = 220;

    private String firstName;
    private String lastName;
    private int day;
    private int month;
    private int year;

    public HeartRates () {}

    public HeartRates(String firstName, String lastName, int day, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAge() {
        return Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears();
    }

    public int getMaxHR() {
        return (int) Math.floor(MAX_HR_SRC - getAge());
    }

    public int getTargetHR() {
        return (int) Math.floor(getMaxHR() * .675);
    }

    @Override
    public HashMap<String, Object> getProperties() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("First name", firstName);
        map.put("Last name", lastName);
        map.put("Date of birth (day)", day);
        map.put("Date of birth (month)", month);
        map.put("Date of birth (year)", year);
        map.put("Date of birth (ISO)", LocalDate.of(year, month, day).format(DateTimeFormatter.ISO_LOCAL_DATE));
        map.put("Age", getAge());
        map.put("Maximum heart rate", getMaxHR());
        map.put("Target heart rate", getTargetHR());
        return map;
    }
}
