package com.owen.scott.programs.chapter3;

import com.owen.scott.annotations.Completed;
import com.owen.scott.programs.commons.OutputUtils;

import java.util.Scanner;

@Completed
public class InvoiceTest implements Runnable {
    private final Scanner sc;

    public InvoiceTest() {
        sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        Invoice invoice1 = new Invoice();
        Invoice invoice2 = new Invoice();

        OutputUtils.printData(invoice1, invoice2);

        System.out.println("Setting all invoice1 values to 5");
        invoice1.setPartDescription("5");
        invoice1.setPartNumber("5");
        invoice1.setPricePerItem(5);
        invoice1.setQuantity(5);

        OutputUtils.printData(invoice1, invoice2);

        System.out.println("Setting all invoice2 values to 6");
        invoice2.setPartDescription("6");
        invoice2.setPartNumber("6");
        invoice2.setPricePerItem(6);
        invoice2.setQuantity(6);

        OutputUtils.printData(invoice1, invoice2);
    }
}