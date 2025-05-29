package com.pluarlsight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Represents a sandwich in an order.
public class Sandwich implements OrderItem {
    private SandwichSize size;
    private BreadType bread;
    private List<Topping> toppings;
    private boolean isToasted;

    private int meatCount = 0;
    private int extraMeatCount = 0;
    private int cheeseCount = 0;
    private int extraCheeseCount = 0;

    // Constructor for Sandwich.
    public Sandwich(SandwichSize size, BreadType bread, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }

    // Adds a topping and updates premium counts.
    public void addTopping(Topping topping, boolean isExtraPortion) {
        this.toppings.add(topping);
        if (topping.getCategory() == ToppingCategory.MEAT) {
            if (isExtraPortion) extraMeatCount++; else meatCount++;
        } else if (topping.getCategory() == ToppingCategory.CHEESE) {
            if (isExtraPortion) extraCheeseCount++; else cheeseCount++;
        }
    }

    // Getters for sandwich properties.
    public SandwichSize getSize() { return size; }
    public BreadType getBread() { return bread; }
    public boolean isToasted() { return isToasted; }
    public List<Topping> getToppings() { return new ArrayList<>(toppings); } // Return copy

    // Setter for toasted status.
    public void setToasted(boolean toasted) { this.isToasted = toasted; }

    // Calculates the price of the sandwich.
    @Override
    public double getPrice() {
        double totalPrice = size.getBasePrice();
        totalPrice += meatCount * size.getMeatPrice();
        totalPrice += extraMeatCount * size.getExtraMeatPrice();
        totalPrice += cheeseCount * size.getCheesePrice();
        totalPrice += extraCheeseCount * size.getExtraCheesePrice();
        return totalPrice;
    }

    // Gets display details for the sandwich.
    @Override
    public String getDisplayDetails() {
        StringBuilder details = new StringBuilder();
        details.append(String.format("CUSTOM SANDWICH (%s)\n", size.getDisplayName()));
        details.append(String.format("  Bread: %s\n", bread.getDisplayName()));
        details.append(String.format("  Toasted: %s\n", isToasted ? "Yes" : "No"));

        // Helper to format list of toppings
        java.util.function.Function<ToppingCategory, String> formatToppings = (cat) ->
                toppings.stream().filter(t -> t.getCategory() == cat).map(Topping::getName).collect(Collectors.joining(", "));

        String meatsStr = formatToppings.apply(ToppingCategory.MEAT);
        if (!meatsStr.isEmpty()) details.append("  Meats: ").append(meatsStr).append("\n");

        String cheesesStr = formatToppings.apply(ToppingCategory.CHEESE);
        if (!cheesesStr.isEmpty()) details.append("  Cheeses: ").append(cheesesStr).append("\n");

        String regularStr = formatToppings.apply(ToppingCategory.REGULAR_TOPPING);
        if (!regularStr.isEmpty()) details.append("  Regular Toppings: ").append(regularStr).append("\n");

        String saucesStr = formatToppings.apply(ToppingCategory.SAUCE);
        if (!saucesStr.isEmpty()) details.append("  Sauces: ").append(saucesStr).append("\n");

        String sidesStr = formatToppings.apply(ToppingCategory.SIDE);
        if (!sidesStr.isEmpty()) details.append("  Sides: ").append(sidesStr).append("\n");

        details.append(String.format("  Subtotal: $%.2f\n", getPrice()));
        return details.toString();
    }
}