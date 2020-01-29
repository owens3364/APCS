package com.owen.scott.programs.chapter8;

public class HourlyEmployee extends Employee {
    private double hoursWorked;
    private double hourlyWage;

    public HourlyEmployee(String firstName, String lastName, String ssn) {
        super(firstName, lastName, ssn);
    }

    public HourlyEmployee(String firstName, String lastName, String ssn, double hoursWorked, double hourlyWage) {
        this(firstName, lastName, ssn);
        this.setHoursWorked(hoursWorked);
        this.setHourlyWage(hourlyWage);
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double weeklyEarnings() {
        return hoursWorked > 40 ? ((40 * hourlyWage) + ((hoursWorked - 40) * hourlyWage * 1.5)) : hoursWorked * hourlyWage;
    }

    @Override
    public String toString() {
        return "\t*\tHourly Employee: " + getFirstName() + " " + getLastName() + "\n\t*\tSocial Security Number: " + getSsn() + "\n\t*\tHourly Wage: " + hourlyWage + "; Hours Worked: " + hoursWorked + "\n\t*\tWeekly Earnings: " + weeklyEarnings();
    }
}
