package com.pluarlsight;

// Manages the overall order building process.
public class OrderScreen {
    private AddSandwichScreen addSandwichScreen;
    private AddDrinkScreen addDrinkScreen;
    private AddChipsScreen addChipsScreen;
    private CheckoutScreen checkoutScreen;
    private Order currentOrder;

    // Constructor for OrderScreen.
    public OrderScreen(ReceiptManager receiptManager) {
        this.addSandwichScreen = new AddSandwichScreen();
        this.addDrinkScreen = new AddDrinkScreen();
        this.addChipsScreen = new AddChipsScreen();
        this.checkoutScreen = new CheckoutScreen(receiptManager);
    }

    // Starts a new order.
    public void startNewOrder() {
        this.currentOrder = new Order(); // Create a new order
        System.out.println("New order started at Kahoot King Deli.");
        manageOrder();
    }

    // Main loop for managing the current order.
    private void manageOrder() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\n--- Kahoot King Deli - Order Screen ---");
            System.out.println(currentOrder.getOrderDetails()); // Display current order

            System.out.println("Options:");
            System.out.println("1) Add Sandwich"); System.out.println("2) Add Drink");
            System.out.println("3) Add Chips"); System.out.println("4) Checkout");
            System.out.println("0) Cancel Order (Return to Home Screen)");
            System.out.println("--------------------");

            int choice = UserInterface.getIntInput("Enter your choice: ", 0, 4);

            switch (choice) {
                case 1: // Add Sandwich
                    Sandwich sandwich = addSandwichScreen.buildSandwich();
                    if (sandwich != null) currentOrder.addItem(sandwich);
                    break;
                case 2: // Add Drink
                    Drink drink = addDrinkScreen.selectDrink();
                    if (drink != null) currentOrder.addItem(drink);
                    break;
                case 3: // Add Chips
                    Chips chips = addChipsScreen.selectChips();
                    if (chips != null) currentOrder.addItem(chips);
                    break;
                case 4: // Checkout
                    if (currentOrder.getItems().isEmpty()) {
                        System.out.println("Your order is empty. Please add items before checking out.");
                    } else {
                        if (checkoutScreen.processCheckout(currentOrder)) ordering = false;
                    }
                    break;
                case 0: // Cancel Order
                    if (UserInterface.getYesNoInput("Are you sure you want to cancel this order? All items will be lost.")) {
                        System.out.println("Order cancelled.");
                        ordering = false;
                    }
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}