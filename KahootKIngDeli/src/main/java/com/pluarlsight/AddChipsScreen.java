package com.pluarlsight;

// Manages adding chips to the order.
public class AddChipsScreen {

    // Guides user to select chip type.
    public Chips selectChips() {
        System.out.println("\n--- Add Chips ---");
        String type = UserInterface.selectFromList("Select chip type:", DataStore.CHIP_TYPES, false);

        if (type != null) {
            Chips chips = new Chips(type);
            System.out.printf("%s chips added to order.\n", type);
            return chips;
        }
        System.out.println("Chip selection cancelled or invalid.");
        return null;
    }
}