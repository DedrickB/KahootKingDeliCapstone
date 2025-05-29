package com.pluarlsight;

// Interface for any item that can be part of an order.
public interface OrderItem {
    double getPrice();           // Gets the price of the item.
    String getDisplayDetails();  // Gets a string representation for display.
}