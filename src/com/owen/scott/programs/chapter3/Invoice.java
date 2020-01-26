package com.owen.scott.programs.chapter3;

import com.owen.scott.programs.commons.TestableProperties;

import java.util.HashMap;

public class Invoice implements TestableProperties {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public double getInvoiceAmount() {
        if (quantity < 0) quantity = 0;
        if (pricePerItem < 0) pricePerItem = 0;
        return quantity * pricePerItem;
    }

    @Override
    public HashMap<String, Object> getProperties() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Amount", getInvoiceAmount());
        map.put("Part description", partDescription);
        map.put("Part number", partNumber);
        map.put("Price per item", pricePerItem);
        map.put("Quantity", quantity);
        return map;
    }
}
