package com.owen.scott.programs.chapter8;

import com.owen.scott.annotations.Completed;

@Completed
public class EmployeeTest implements Runnable {
    CommissionEmployee employee1;
    BasePlusCommission employee2;
    HourlyEmployee employee3;
    SalariedEmployee employee4;

    @Override
    public void run() {
        employee1 = new CommissionEmployee("Sue", "Jones", "222-22-2222", .06, 10000);
        employee2 = new BasePlusCommission("Jeff", "Michaels", "333-33-3333", .02, 8500, 2000);
        employee3 = new HourlyEmployee("Sarah", "Thomas", "444-44-4444", 45, 18.50);
        employee4 = new SalariedEmployee("Timothy", "Jones", "555-55-5555", 2500);
        printDetailsFromGetMethods();
        updateEmployees();
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
        System.out.println(employee3.toString());
        System.out.println(employee4.toString());
    }

    private void printDetailsFromGetMethods() {
        System.out.println("EMPLOYEE 1 INFORMATION OBTAINED VIA GET METHODS");
        System.out.println("First name: " + employee1.getFirstName());
        System.out.println("Last name: " + employee1.getLastName());
        System.out.println("Social Security Number: " + employee1.getSsn());
        System.out.println("Gross sales: " + employee1.getWeeklySales());
        System.out.println("Commission Rate: " + employee1.getCommissionRate());
        System.out.println("Earnings: " + employee1.weeklyEarnings());

        System.out.println("EMPLOYEE 2 INFORMATION OBTAINED BY GET METHODS");
        System.out.println("First name: " + employee2.getFirstName());
        System.out.println("Last name: " + employee2.getLastName());
        System.out.println("Social Security Number: " + employee2.getSsn());
        System.out.println("Gross Sales: " + employee2.getWeeklySales());
        System.out.println("Commission Rate: " + employee2.getCommissionRate());
        System.out.println("Base Salary: " + employee2.getBaseSalary());
        System.out.println("Earnings: " + employee2.weeklyEarnings());

        System.out.println("EMPLOYEE 3 INFORMATION OBTAINED BY GET METHODS");
        System.out.println("First name: " + employee3.getFirstName());
        System.out.println("Last name: " + employee3.getLastName());
        System.out.println("Social Security Number: " + employee3.getSsn());
        System.out.println("Hourly Wage: " + employee3.getHourlyWage());
        System.out.println("Hours Worked: " + employee3.getHoursWorked());
        System.out.println("Earnings: " + employee3.weeklyEarnings());

        System.out.println("EMPLOYEE 4 INFORMATION OBTAINED BY GET METHODS");
        System.out.println("First name: " + employee4.getFirstName());
        System.out.println("Last name: " + employee4.getLastName());
        System.out.println("Social Security Number: " + employee4.getSsn());
        System.out.println("Weekly Salary: " + employee4.getWeeklySalary());
        System.out.println("Earnings: " + employee4.weeklyEarnings());
    }

    private void updateEmployees() {
        employee1.setWeeklySales(15000);
        employee1.setCommissionRate(.04);
        employee2.setWeeklySales(12500);
        employee2.setCommissionRate(.03);
        employee2.setBaseSalary(6000);
        employee3.setHourlyWage(23.75);
        employee3.setHoursWorked(40);
        employee4.setWeeklySalary(3000);
    }
}
