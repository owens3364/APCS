package com.owen.scott.programs.chapter7;

import java.util.LinkedList;
import java.util.List;

public class Slip {
    public Slip(int salesPersonNumber, int productNumber) {
        this.salesPersonNumber = salesPersonNumber;
        this.productNumber = productNumber;
    }

    private final int salesPersonNumber;
    private final int productNumber;

    public int getSalesPersonNumber() {
        return salesPersonNumber;
    }

    public int getProductNumber() {
        return productNumber;
    }


    static List<Slip> sortBySalesPersonNumber(List<Slip> slips) {
        int pivot = slips.get(0).salesPersonNumber;
        List<Slip> left = new LinkedList<>();
        List<Slip> pivotList = new LinkedList<>();
        List<Slip> right = new LinkedList<>();
        for (Slip slip : slips) {
            if (slip.salesPersonNumber < pivot) {
                left.add(slip);
            } else if (slip.salesPersonNumber > pivot) {
                right.add(slip);
            } else {
                pivotList.add(slip);
            }
        }
        left = sortBySalesPersonNumber(left);
        right = sortBySalesPersonNumber(right);
        left.addAll(pivotList);
        left.addAll(right);
        return left;
    }
}
