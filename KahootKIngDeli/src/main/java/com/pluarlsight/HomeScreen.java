package com.pluarlsight;

// Manages the application's home screen.
public class HomeScreen {

    // Displays home screen options and gets user choice.
    public int display() {
        System.out.println("\nWelcome to Kahoot King Deli!");
        System.out.println("Home Screen");
        System.out.println("--------------------");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.println("--------------------");
        return UserInterface.getIntInput("Enter your choice: ", 0, 1);
    }
}