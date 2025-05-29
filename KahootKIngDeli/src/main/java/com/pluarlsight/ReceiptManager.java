package com.pluarlsight;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Manages saving order receipts to files.
public class ReceiptManager {
    private static final String RECEIPTS_FOLDER = "receipts";

    // Constructor: ensures receipts folder exists.
    public ReceiptManager() {
        File folder = new File(RECEIPTS_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Saves the receipt for a given order.
    public void saveReceipt(Order order) {
        String fileName = RECEIPTS_FOLDER + File.separator + order.getFormattedDateTime() + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(order.getReceiptDetails());
            System.out.println("Receipt saved successfully to: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
        }
    }
}
