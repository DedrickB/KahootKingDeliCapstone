package com.pluarlsight;

// Enum for drink sizes and their prices.
public enum DrinkSize {
    SMALL("Small", 2.00),
    MEDIUM("Medium", 2.50),
    LARGE("Large", 3.00);

    private final String displayName;
    private final double price;

    // Constructor for drink sizes.
    DrinkSize(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    // Getters for drink size properties.
    public String getDisplayName() { return displayName; }
    public double getPrice() { return price; }

    @Override
    public String toString() { return displayName; } // For display
}