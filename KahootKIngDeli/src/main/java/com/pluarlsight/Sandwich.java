package com.pluarlsight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich implements OrderItem {
    private SandwichSize size;
    private BreadType bread;
    private List<Topping> toppings;
    private boolean isToasted;

    private int meatCount = 0;
    private int extraMeatCount = 0;
    private int cheeseCount = 0;
    private int extraCheeseCount = 0;

    public Sandwich(SandwichSize size, BreadType bread, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping, boolean isExtraPortion) {
        this.toppings.add(topping);
        if (topping.getCategory() == ToppingCategory.MEAT) {
            if (isExtraPortion) {
                extraMeatCount++;
            } else {
                meatCount++;
            }
        } else if (topping.getCategory() == ToppingCategory.CHEESE) {
            if (isExtraPortion) {
                extraCheeseCount++;
            } else {
                cheeseCount++;
            }
        }
    }

    public SandwichSize getSize() {
        return size;
    }

    public BreadType getBread() {
        return bread;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    @Override
    public double getPrice() {
        double totalPrice = size.getBasePrice();
        totalPrice += meatCount * size.getMeatPrice();
        totalPrice += extraMeatCount * size.getExtraMeatPrice();
        totalPrice += cheeseCount * size.getCheesePrice();
        totalPrice += extraCheeseCount * size.getExtraCheesePrice();
        return totalPrice;
    }

    @Override
    public String getDisplayDetails() {
        StringBuilder details = new StringBuilder();
        details.append(String.format("CUSTOM SANDWICH (%s)\n", size.getDisplayName()));
        details.append(String.format("  Bread: %s\n", bread.getDisplayName()));
        details.append(String.format("  Toasted: %s\n", isToasted ? "Yes" : "No"));

        List<Topping> meats = toppings.stream().filter(t -> t.getCategory() == ToppingCategory.MEAT).collect(Collectors.toList());
        List<Topping> cheeses = toppings.stream().filter(t -> t.getCategory() == ToppingCategory.CHEESE).collect(Collectors.toList());
        List<Topping> regular = toppings.stream().filter(t -> t.getCategory() == ToppingCategory.REGULAR_TOPPING).collect(Collectors.toList());
        List<Topping> sauces = toppings.stream().filter(t -> t.getCategory() == ToppingCategory.SAUCE).collect(Collectors.toList());
        List<Topping> sides = toppings.stream().filter(t -> t.getCategory() == ToppingCategory.SIDE).collect(Collectors.toList());

        if (!meats.isEmpty()) {
            details.append("  Meats: ").append(meats.stream().map(Topping::getName).collect(Collectors.joining(", "))).append("\n");
        }
        if (!cheeses.isEmpty()) {
            details.append("  Cheeses: ").append(cheeses.stream().map(Topping::getName).collect(Collectors.joining(", "))).append("\n");
        }
        if (!regular.isEmpty()) {
            details.append("  Regular Toppings: ").append(regular.stream().map(Topping::getName).collect(Collectors.joining(", "))).append("\n");
        }
        if (!sauces.isEmpty()) {
            details.append("  Sauces: ").append(sauces.stream().map(Topping::getName).collect(Collectors.joining(", "))).append("\n");
        }
        if (!sides.isEmpty()) {
            details.append("  Sides: ").append(sides.stream().map(Topping::getName).collect(Collectors.joining(", "))).append("\n");
        }
        details.append(String.format("  Subtotal: $%.2f\n", getPrice()));
        return details.toString();
    }
}