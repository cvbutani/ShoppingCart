package com.company.example;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<ShoppingItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new LinkedHashMap<>();
    }

    public int addToBasket(ShoppingItem itemName, int quantity) {
        if ((itemName != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(itemName, 0);
            list.put(itemName, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<ShoppingItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    public void checkOut(){
        for (Map.Entry<ShoppingItem, Integer> item : list.entrySet()){
            if(StockIist.list.containsKey(item.getKey().getName())){
               int quantity = StockIist.list.get(item.getKey().getName()).getQuantity() - item.getValue();
                StockIist.list.get(item.getKey().getName()).adjustQuantity(quantity);
            }
        }
        list.clear();
    }

    @Override
    public String toString() {
        String s = "\nPurchase items are \n";
        double totalCost = 0.0;
        for (Map.Entry<ShoppingItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased.\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total Cost is: " + String.format("%.2f", totalCost) + ". Total Items are "+ list.size();
    }


}
