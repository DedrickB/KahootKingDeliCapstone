# Kahoot King Deli - Point of Sale (POS) Application

## Project Description

This project is a console-based Point of Sale (POS) application designed for **Kahoot King Deli**, a custom sandwich shop. The system automates the order-taking process, allowing users (simulating customers or staff) to build custom sandwich orders, add drinks and chips, and complete the transaction. Upon checkout, a detailed receipt is generated and saved to a file.

The application is developed using Java, with a strong emphasis on Object-Oriented Programming (OOP) principles to ensure a modular, maintainable, and extensible codebase.

## Core Features

*   **Custom Sandwich Building:**
    *   Selection of sandwich size (4", 8", 12").
    *   Choice of bread type (White, Wheat, Rye, Wrap).
    *   Addition of multiple toppings categorized as:
        *   **Meats** (premium, with optional extra portions at additional cost).
        *   **Cheeses** (premium, with optional extra portions at additional cost).
        *   **Regular Toppings** (lettuce, tomatoes, etc. - included in base price).
        *   **Sauces** (mayo, mustard, etc. - included).
        *   **Sides** (e.g., Au Jus - included).
    *   Option to have the sandwich toasted.
*   **Order Add-ons:**
    *   Ability to add drinks (selecting size and flavor).
    *   Ability to add chips (selecting type).
*   **Order Management:**
    *   Users can add multiple items (sandwiches, drinks, chips) to a single order.
    *   The current order details are displayed, with the newest items appearing first.
*   **Checkout Process:**
    *   A final review of the entire order with all customizations and total price is shown.
    *   Users can confirm the order or cancel to go back and modify it.
*   **Receipt Generation:**
    *   On order confirmation, a text file receipt is automatically generated.
    *   Receipts are stored in a `receipts` folder within the application's running directory.
    *   Receipt filenames are timestamped: `yyyyMMdd-HHmmss.txt` (e.g., `20231027-153045.txt`).
*   **User Interface:**
    *   **Home Screen:** Options to start a "New Order" or "Exit".
    *   **Order Screen:** Options to "Add Sandwich", "Add Drink", "Add Chips", "Checkout", or "Cancel Order".

## Technologies Used

*   **Java:** Core programming language.
*   **Object-Oriented Programming (OOP):** Design principles like encapsulation, inheritance (via interfaces), and polymorphism are utilized.
*   **Git & GitHub:** For version control and repository hosting.

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 8 or higher installed and configured on your system.
*   Git installed (for cloning the repository).

### Setup and Run

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/YourUsername/kahoot-king-deli-pos.git
    cd kahoot-king-deli-pos
    ```
    *(Replace `YourUsername` with your actual GitHub username)*

2.  **Compile the Java files:**
    Navigate to the root directory of the cloned project (the one containing the `com` folder) in your terminal and run:
    ```bash
    javac com/pluralsight/*.java
    ```

3.  **Run the application:**
    From the same root directory, run:
    ```bash
    java com.pluralsight.KahootKingDeliApp
    ```

4.  The application will start in your console. Follow the on-screen prompts to place an order.
5.  Receipts for completed orders will be saved in a `receipts` folder created in the project's root directory.

## Application Screen Examples (Console Output)

*(These are text representations of what the console output looks like.)*

**1. Home Screen:**
