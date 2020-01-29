package com.owen.scott.programs.chapter8;

public class BasePlusCommission extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommission(String firstName, String lastName, String ssn, double commissionRate, double weeklySales) {
        super(firstName, lastName, ssn, commissionRate, weeklySales);
    }

    public BasePlusCommission(String firstName, String lastName, String ssn, double commissionRate, double weeklySales, double baseSalary) {
        this(firstName, lastName, ssn, commissionRate, weeklySales);
        this.setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double weeklyEarnings() {
        return super.weeklyEarnings() + baseSalary;
    }

    @Override
    public String toString() {
        return "\t*\tBase Plus Commission Employee: " + getFirstName() + " " + getLastName() + "\n\t*\tSocial Security Number: " + getSsn() + "\n\t*\tGross Sales: " + getWeeklySales() + "; Commission Rate" + getCommissionRate() + "; Base Salary: " + baseSalary + "\n\t*\tWeekly Earnings: " + weeklyEarnings();
    }
}
