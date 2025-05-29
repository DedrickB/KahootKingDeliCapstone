package com.pluarlsight;

// Represents a drink in an order.
public class Drink implements OrderItem {
    private DrinkSize size;
    private String flavor;

    // Constructor for Drink.
    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    // Getters for drink properties.
    public DrinkSize getSize() { return size; }
    public String getFlavor() { return flavor; }

    // Gets the price based on size.
    @Override
    public double getPrice() { return size.getPrice(); }

    // Gets display details for the drink.
    @Override
    public String getDisplayDetails() {
        return String.format("DRINK: %s %s - $%.2f", size.getDisplayName(), flavor, getPrice());
    }
}