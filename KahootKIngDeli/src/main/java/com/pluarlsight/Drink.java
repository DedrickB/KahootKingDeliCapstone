package com.pluarlsight;

public class Drink implements OrderItem {
    private DrinkSize size;
    private String flavor;

    public Drink(DrinkSize size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public DrinkSize getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String getDisplayDetails() {
        return String.format("DRINK: %s %s - $%.2f", size.getDisplayName(), flavor, getPrice());
    }
}