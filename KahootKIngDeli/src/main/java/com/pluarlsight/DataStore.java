package com.pluarlsight;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

// Stores predefined application options like toppings, drinks, etc.
public class DataStore {

    public static final List<BreadType> BREAD_TYPES = Arrays.asList(BreadType.values());
    public static final List<SandwichSize> SANDWICH_SIZES = Arrays.asList(SandwichSize.values());

    public static final Map<String, ToppingCategory> MEATS = new LinkedHashMap<>();
    static {
        MEATS.put("Steak", ToppingCategory.MEAT); MEATS.put("Ham", ToppingCategory.MEAT);
        MEATS.put("Salami", ToppingCategory.MEAT); MEATS.put("Roast Beef", ToppingCategory.MEAT);
        MEATS.put("Chicken", ToppingCategory.MEAT); MEATS.put("Bacon", ToppingCategory.MEAT);
    }

    public static final Map<String, ToppingCategory> CHEESES = new LinkedHashMap<>();
    static {
        CHEESES.put("American", ToppingCategory.CHEESE); CHEESES.put("Provolone", ToppingCategory.CHEESE);
        CHEESES.put("Cheddar", ToppingCategory.CHEESE); CHEESES.put("Swiss", ToppingCategory.CHEESE);
    }

    public static final Map<String, ToppingCategory> REGULAR_TOPPINGS = new LinkedHashMap<>();
    static {
        REGULAR_TOPPINGS.put("Lettuce", ToppingCategory.REGULAR_TOPPING); REGULAR_TOPPINGS.put("Peppers", ToppingCategory.REGULAR_TOPPING);
        REGULAR_TOPPINGS.put("Onions", ToppingCategory.REGULAR_TOPPING); REGULAR_TOPPINGS.put("Tomatoes", ToppingCategory.REGULAR_TOPPING);
        REGULAR_TOPPINGS.put("Jalapenos", ToppingCategory.REGULAR_TOPPING); REGULAR_TOPPINGS.put("Cucumbers", ToppingCategory.REGULAR_TOPPING);
        REGULAR_TOPPINGS.put("Pickles", ToppingCategory.REGULAR_TOPPING); REGULAR_TOPPINGS.put("Guacamole", ToppingCategory.REGULAR_TOPPING);
        REGULAR_TOPPINGS.put("Mushrooms", ToppingCategory.REGULAR_TOPPING);
    }

    public static final Map<String, ToppingCategory> SAUCES = new LinkedHashMap<>();
    static {
        SAUCES.put("Mayo", ToppingCategory.SAUCE); SAUCES.put("Mustard", ToppingCategory.SAUCE);
        SAUCES.put("Ketchup", ToppingCategory.SAUCE); SAUCES.put("Ranch", ToppingCategory.SAUCE);
        SAUCES.put("Thousand Islands", ToppingCategory.SAUCE); SAUCES.put("Vinaigrette", ToppingCategory.SAUCE);
    }

    public static final Map<String, ToppingCategory> SIDES = new LinkedHashMap<>();
    static {
        SIDES.put("Au Jus", ToppingCategory.SIDE);
    }

    public static final List<DrinkSize> DRINK_SIZES = Arrays.asList(DrinkSize.values());
    public static final List<String> DRINK_FLAVORS = Arrays.asList(
            "Cola", "Lemon-Lime Soda", "Orange Soda", "Root Beer", "Iced Tea", "Water"
    );

    public static final List<String> CHIP_TYPES = Arrays.asList(
            "Regular Potato", "BBQ", "Sour Cream & Onion", "Salt & Vinegar", "Cheddar Crisps"
    );
}