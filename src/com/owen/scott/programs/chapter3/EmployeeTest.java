package com.owen.scott.programs.chapter3;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.OutputUtils;

@Completed
public class EmployeeTest implements Runnable {

    @Override
    public void run() {
        Employee employee1 = new Employee("Jim", "John", 10);
        Employee employee2 = new Employee("Unkle", "Bob", 20);

        OutputUtils.printData(employee1, employee2);

        System.out.println("Giving both employees a 10% raise.");

        employee1.setMonthlySalary(employee1.getMonthlySalary() * 1.1);
        employee2.setMonthlySalary(employee2.getMonthlySalary() * 1.1);

        OutputUtils.printData(employee1, employee2);
    }
}
