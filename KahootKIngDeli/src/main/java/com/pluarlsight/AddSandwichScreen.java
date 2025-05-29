package com.pluarlsight;

import java.util.Map;

// Manages creating a new sandwich.
public class AddSandwichScreen {

    // Guides user through building a sandwich.
    public Sandwich buildSandwich() {
        System.out.println("\n--- Add New Sandwich ---");

        SandwichSize size = UserInterface.selectFromList("Select sandwich size:", DataStore.SANDWICH_SIZES, false);
        if (size == null) { System.out.println("Sandwich creation aborted."); return null; }

        BreadType bread = UserInterface.selectFromList("Select your bread:", DataStore.BREAD_TYPES, false);
        if (bread == null) { System.out.println("Sandwich creation aborted."); return null; }

        Sandwich sandwich = new Sandwich(size, bread, false); // Initial toasted status is false

        System.out.println("\n--- Select Toppings ---");
        addPremiumToppings(sandwich, "Meat Options", DataStore.MEATS, size.getMeatPrice(), size.getExtraMeatPrice());
        addPremiumToppings(sandwich, "Cheese Options", DataStore.CHEESES, size.getCheesePrice(), size.getExtraCheesePrice());

        System.out.println("\n--- Regular Toppings (Included) ---");
        addRegularItems(sandwich, "Regular Topping", DataStore.REGULAR_TOPPINGS);

        System.out.println("\n--- Sauces (Included) ---");
        addRegularItems(sandwich, "Sauce", DataStore.SAUCES);

        System.out.println("\n--- Sides (Included) ---");
        addRegularItems(sandwich, "Side", DataStore.SIDES);

        sandwich.setToasted(UserInterface.getYesNoInput("Would you like the sandwich toasted?"));

        System.out.println("\nSandwich configured!");
        return sandwich;
    }

    // Helper for adding premium toppings.
    private void addPremiumToppings(Sandwich sandwich, String categoryName, Map<String, ToppingCategory> premiumToppingsMap, double standardPrice, double extraPrice) {
        while (true) {
            System.out.println("\n--- " + categoryName + " ---");
            Topping selectedTopping = UserInterface.selectToppingFromMap(
                    "Select " + categoryName.replace(" Options", "") + " (or 'Done with this category')",
                    premiumToppingsMap, true);

            if (selectedTopping == null) break;

            sandwich.addTopping(selectedTopping, false);
            System.out.printf("%s added. Standard portion price for %s size: $%.2f\n",
                    selectedTopping.getName(), sandwich.getSize().getDisplayName(), standardPrice);

            if (UserInterface.getYesNoInput("Add extra " + selectedTopping.getName() + "? (Additional cost: $" + String.format("%.2f", extraPrice) + ")")) {
                sandwich.addTopping(selectedTopping, true);
                System.out.printf("Extra %s added. Additional price: $%.2f\n", selectedTopping.getName(), extraPrice);
            }
            if (!UserInterface.getYesNoInput("Add another " + categoryName.replace(" Options", "").toLowerCase() + " from this category?")) break;
        }
    }

    // Helper for adding regular toppings/sauces/sides.
    private void addRegularItems(Sandwich sandwich, String itemType, Map<String, ToppingCategory> itemMap) {
        while (UserInterface.getYesNoInput("Would you like to add any " + itemType.toLowerCase() + "s?")) {
            Topping selectedItem = UserInterface.selectToppingFromMap("Select " + itemType, itemMap, false);
            if (selectedItem != null) {
                sandwich.addTopping(selectedItem, false);
                System.out.println(selectedItem.getName() + " added.");
            } else {
                System.out.println("No " + itemType.toLowerCase() + " selected, or selection failed.");
                break;
            }
            if (!UserInterface.getYesNoInput("Add another " + itemType.toLowerCase() + "?")) break;
        }
    }
}