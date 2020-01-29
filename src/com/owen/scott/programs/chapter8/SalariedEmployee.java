package com.owen.scott.programs.chapter8;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String ssn) {
        super(firstName, lastName, ssn);
    }

    public SalariedEmployee(String firstName, String lastName, String ssn, double weeklySalary) {
        this(firstName, lastName, ssn);
        this.setWeeklySalary(weeklySalary);
    }

    @Override
    public double weeklyEarnings() {
        return weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public String toString() {
        return "\t*\tSalaried Employee: " + getFirstName() + " " + getLastName() + "\n\t*\tSocial Security Number: " + getSsn() + "\n\t*\tWeekly Salary: " + weeklySalary + "\n\t*\tWeekly Earnings: " + weeklyEarnings();
    }
}
