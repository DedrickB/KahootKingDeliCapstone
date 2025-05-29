package com.pluarlsight;

// Represents a single sandwich topping.
public class Topping {
    private String name;
    private ToppingCategory category;
    private boolean isPremium;

    // Constructor for Topping.
    public Topping(String name, ToppingCategory category) {
        this.name = name;
        this.category = category;
        this.isPremium = (category == ToppingCategory.MEAT || category == ToppingCategory.CHEESE);
    }

    // Getters for topping properties.
    public String getName() { return name; }
    public ToppingCategory getCategory() { return category; }
    public boolean isPremium() { return isPremium; }

    @Override
    public String toString() { return name; } // For display
}