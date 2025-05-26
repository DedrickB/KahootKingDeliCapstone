package com.pluarlsight;

public class Chips implements OrderItem {
    private String type;
    private static final double PRICE = 1.50;

    public Chips(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public String getDisplayDetails() {
        return String.format("CHIPS: %s - $%.2f", type, getPrice());
    }
}