package com.owen.scott.programs.chapter8;

public class CommissionEmployee extends Employee {
    private double commissionRate;
    private double weeklySales;

    public CommissionEmployee(String firstName, String lastName, String ssn) {
        super(firstName, lastName, ssn);
    }

    public CommissionEmployee(String firstName, String lastName, String ssn, double commissionRate, double weeklySales) {
        this(firstName, lastName, ssn);
        this.setCommissionRate(commissionRate);
        this.setWeeklySales(weeklySales);
    }


    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getWeeklySales() {
        return weeklySales;
    }

    public void setWeeklySales(double weeklySales) {
        this.weeklySales = weeklySales;
    }

    @Override
    public double weeklyEarnings() {
        return weeklySales * commissionRate;
    }

    @Override
    public String toString() {
        return "\t*\tCommission Employee: " + getFirstName() + " " + getLastName() + "\n\t*\tSocial Security Number: " + getSsn() + "\n\t*\tGross Sales: " + weeklySales + "; Commission Rate: " + commissionRate + "\n\t*\tWeekly Earnings: " + weeklyEarnings();
    }
}
