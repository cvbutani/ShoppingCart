package com.company.example;

import java.util.*;

public class StockIist {
    public static Map<String, ShoppingItem> list;

    public StockIist() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(ShoppingItem item) {
        if (item != null) {
            ShoppingItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustQuantity(inStock.getQuantity());
                return 0;
            }
            list.put(item.getName(), item);
            return item.getQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        ShoppingItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.getQuantity() >= quantity) && (quantity > 0)) {
            inStock.adjustQuantity(-quantity);
                return quantity;
        }
        return 0;
    }

    public int reserveItem(String name, int quantity) {
        Map<String, Integer> newList = new LinkedHashMap<>();
        ShoppingItem inStock = list.getOrDefault(name, null);
        if ((inStock != null) && (inStock.getQuantity() >= quantity) && (quantity > 0)) {
            newList.put(name, quantity);
            System.out.println(newList);
            return 1;
        }
        return 0;
    }

    public ShoppingItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> priceList(){
        Map<String, Double> price = new LinkedHashMap<>();
        for (Map.Entry<String, ShoppingItem> item : list.entrySet()) {
            price.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(price);
    }

    public Map<String, ShoppingItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, ShoppingItem> item : list.entrySet()) {
            ShoppingItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantity();
            s = s + stockItem + ". There are " + stockItem.getQuantity() + " in stock. Value of Stock is " + String.format("%.2f", itemValue) + ". \n";
            totalCost += itemValue;
        }
        return s + "Total Cost is: " + String.format("%.2f", totalCost) + ".";
    }
}
