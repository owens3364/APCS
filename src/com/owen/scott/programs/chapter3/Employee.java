package com.owen.scott.programs.chapter3;

import com.owen.scott.programs.commons.TestableProperties;

import java.util.HashMap;

public class Employee implements TestableProperties {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(){}

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (monthlySalary > 0) this.monthlySalary = monthlySalary;
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

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public HashMap<String, Object> getProperties() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("First name", firstName);
        map.put("Last name", lastName);
        map.put("Monthly salary", monthlySalary);
        map.put("Yearly salary", monthlySalary * 12);
        return map;
    }
}
