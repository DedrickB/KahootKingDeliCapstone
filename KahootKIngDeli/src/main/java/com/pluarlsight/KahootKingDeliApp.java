package com.pluarlsight;

// Main application class for Kahoot King Deli.
public class KahootKingDeliApp {
    private HomeScreen homeScreen;
    private OrderScreen orderScreen;
    private ReceiptManager receiptManager;

    // Constructor for the application.
    public KahootKingDeliApp() {
        this.receiptManager = new ReceiptManager();
        this.homeScreen = new HomeScreen();
        this.orderScreen = new OrderScreen(receiptManager);
    }

    // Runs the main application loop.
    public void run() {
        boolean running = true;
        while (running) {
            int choice = homeScreen.display();
            switch (choice) {
                case 1: // New Order
                    orderScreen.startNewOrder();
                    break;
                case 0: // Exit
                    running = false;
                    System.out.println("Exiting Kahoot King Deli. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice from Home Screen.");
            }
        }
        UserInterface.closeScanner(); // Close scanner on exit
    }

    // Main method - entry point of the application.
    public static void main(String[] args) {
        KahootKingDeliApp app = new KahootKingDeliApp();
        app.run();
    }
}