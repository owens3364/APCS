package com.owen.scott.programs.chapter8;

public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final String ssn;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public abstract double weeklyEarnings();

    @Override
    public String toString() {
        return "\t*\tName: " + firstName + " " + lastName + "\n\t*\tSocial Security Number: " + ssn;
    }
}
