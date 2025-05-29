package com.pluarlsight;

// Manages the checkout process.
public class CheckoutScreen {
    private ReceiptManager receiptManager;

    // Constructor for CheckoutScreen.
    public CheckoutScreen(ReceiptManager receiptManager) {
        this.receiptManager = receiptManager;
    }

    // Processes the checkout for an order.
    public boolean processCheckout(Order order) {
        System.out.println("\n--- Checkout ---");
        System.out.println("Please review your order:");
        System.out.println(order.getOrderDetails());

        if (order.getItems().isEmpty()) { // Check if order is empty
            System.out.println("Your order is empty. Nothing to checkout.");
            return false;
        }

        int choice = UserInterface.getIntInput(
                "1) Confirm Order\n0) Cancel and Return to Order Screen\nEnter choice: ", 0, 1);

        if (choice == 1) {
            receiptManager.saveReceipt(order);
            System.out.println("Order confirmed. Thank you for your purchase at Kahoot King Deli!");
            return true; // Order completed
        } else {
            System.out.println("Checkout cancelled. Returning to order screen.");
            return false; // Checkout cancelled
        }
    }
}
