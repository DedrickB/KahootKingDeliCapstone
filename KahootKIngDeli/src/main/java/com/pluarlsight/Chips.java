package com.pluarlsight;

// Represents chips in an order.
public class Chips implements OrderItem {
    private String type;
    private static final double PRICE = 1.50; // Fixed price for chips

    // Constructor for Chips.
    public Chips(String type) {
        this.type = type;
    }

    public String getType() { return type; }

    // Gets the fixed price of chips.
    @Override
    public double getPrice() { return PRICE; }

    // Gets display details for the chips.
    @Override
    public String getDisplayDetails() {
        return String.format("CHIPS: %s - $%.2f", type, getPrice());
    }
}