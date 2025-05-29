package com.pluarlsight;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

// Utility for console user interactions.
public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    // Gets an integer input within a range.
    public static int getIntInput(String prompt, int min, int max) {
        int choice = -1;
        while (true) {
            System.out.print(prompt);
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) break;
                else System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }

    // Gets a string input.
    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // Gets a Yes/No input.
    public static boolean getYesNoInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (Y/N): ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y") || input.equals("N")) break;
            else System.out.println("Invalid input. Please enter Y or N.");
        }
        return input.equals("Y");
    }

    // Displays a list and gets user selection.
    public static <T> T selectFromList(String prompt, List<T> options, boolean allowNone) {
        if (options == null || options.isEmpty()) {
            System.out.println("No options available for: " + prompt);
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("  %d) %s\n", i + 1, options.get(i).toString());
        }
        int noneOptionIndex = options.size() + 1;
        if (allowNone) System.out.printf("  %d) None/Done\n", noneOptionIndex);

        int minChoice = 1;
        int maxChoice = allowNone ? noneOptionIndex : options.size();
        int choice = getIntInput("Enter your choice: ", minChoice, maxChoice);

        if (allowNone && choice == noneOptionIndex) return null;
        if (choice >= 1 && choice <= options.size()) return options.get(choice - 1);
        return null;
    }

    // Displays toppings from a map and gets user selection.
    public static Topping selectToppingFromMap(String prompt, Map<String, ToppingCategory> toppingMap, boolean allowNone) {
        List<String> toppingNames = new ArrayList<>(toppingMap.keySet());
        if (toppingNames.isEmpty()) {
            String itemType = prompt.toLowerCase().replace("select ", "").replace(" (or 'done with this category')", "");
            System.out.println("No " + itemType + " available.");
            return null;
        }
        System.out.println(prompt);
        for (int i = 0; i < toppingNames.size(); i++) {
            System.out.printf("  %d) %s\n", i + 1, toppingNames.get(i));
        }
        int noneOption = toppingNames.size() + 1;
        if (allowNone) System.out.printf("  %d) None/Done with this category\n", noneOption);

        String choicePromptPart = prompt.substring(prompt.toLowerCase().indexOf("select ") + "select ".length());
        if (choicePromptPart.contains(" (or 'Done")) {
            choicePromptPart = choicePromptPart.substring(0, choicePromptPart.indexOf(" (or 'Done"));
        }
        if (choicePromptPart.trim().isEmpty()) choicePromptPart = "item";
        String finalChoicePrompt = "Select " + choicePromptPart.trim() + ": ";

        int choice = getIntInput(finalChoicePrompt, 1, allowNone ? noneOption : toppingNames.size());

        if (allowNone && choice == noneOption) return null;
        if (choice >= 1 && choice <= toppingNames.size()) {
            String selectedName = toppingNames.get(choice - 1);
            return new Topping(selectedName, toppingMap.get(selectedName));
        }
        return null;
    }

    // Displays a message.
    public static void displayMessage(String message) { System.out.println(message); }

    // Closes the scanner.
    public static void closeScanner() {
        if (scanner != null) scanner.close();
    }
}

