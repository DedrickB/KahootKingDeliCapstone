package com.pluarlsight;

// Manages adding a drink to the order.
public class AddDrinkScreen {

    // Guides user to select drink size and flavor.
    public Drink selectDrink() {
        System.out.println("\n--- Add Drink ---");
        DrinkSize size = UserInterface.selectFromList("Select drink size:", DataStore.DRINK_SIZES, false);
        String flavor = UserInterface.selectFromList("Select drink flavor:", DataStore.DRINK_FLAVORS, false);

        if (size != null && flavor != null) {
            Drink drink = new Drink(size, flavor);
            System.out.printf("%s %s added to order.\n", size.getDisplayName(), flavor);
            return drink;
        }
        System.out.println("Drink selection cancelled or invalid.");
        return null;
    }
}