package com.pluarlsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a customer's order.
public class Order {
    private List<OrderItem> items;
    private LocalDateTime orderDateTime;

    // Constructor for Order.
    public Order() {
        this.items = new ArrayList<>();
        this.orderDateTime = LocalDateTime.now();
    }

    // Adds an item to the order.
    public void addItem(OrderItem item) { this.items.add(item); }

    // Gets items (newest first for screen display).
    public List<OrderItem> getItems() {
        List<OrderItem> reversedItems = new ArrayList<>(this.items);
        Collections.reverse(reversedItems);
        return reversedItems;
    }

    // Gets items in original order (for receipt).
    public List<OrderItem> getItemsForReceipt() { return new ArrayList<>(this.items); }

    // Calculates the total price of the order.
    public double calculateTotalPrice() {
        return items.stream().mapToDouble(OrderItem::getPrice).sum();
    }

    // Gets formatted date-time for filenames.
    public String getFormattedDateTime() {
        return orderDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
    }

    public LocalDateTime getOrderDateTime() { return orderDateTime; }

    // Gets display details for the current order screen.
    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        if (items.isEmpty()) {
            details.append("Order is currently empty.\n");
        } else {
            details.append("---- CURRENT ORDER ----\n");
            getItems().forEach(item -> details.append(item.getDisplayDetails()).append("\n"));
        }
        details.append("-----------------------\n");
        details.append(String.format("TOTAL: $%.2f\n", calculateTotalPrice()));
        return details.toString();
    }

    // Gets display details for the receipt.
    public String getReceiptDetails() {
        StringBuilder details = new StringBuilder();
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        details.append("Receipt for Order placed on: ").append(orderDateTime.format(displayFormatter)).append("\n");
        details.append("----------------------------------------\n");
        getItemsForReceipt().forEach(item -> details.append(item.getDisplayDetails()).append("\n"));
        details.append("----------------------------------------\n");
        details.append(String.format("TOTAL ORDER COST: $%.2f\n", calculateTotalPrice()));
        details.append("Thank you for your business at Kahoot King Deli!\n");
        return details.toString();
    }
}