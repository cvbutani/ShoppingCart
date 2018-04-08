package com.company.example;

public class ShoppingItem implements Comparable<ShoppingItem> {
    private final String name;
    private int quantityAvailable;
    private double price;
    private int reserved = 0;

    public ShoppingItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityAvailable = 0;
    }

    //  Overloading Constructor
    public ShoppingItem(String name, int quantityAvailable, double price) {
        this.name = name;
        this.quantityAvailable = quantityAvailable;
        this.price = price;
    }

    String getName() {
        return name;
    }

    public int getQuantity() {
        return quantityAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }   //  Adjusting price

    public int getQuantityAvailable() {
        return quantityAvailable - reserved;
    }

    public int reserveStock(int quantity) {
        if (quantity <= reserved) {
            reserved -= quantityAvailable;
            return quantity;
        }
        return 0;
    }

    public int unReserveStock(int quantity) {
        if (quantityAvailable <= reserved) {
            quantity -= reserved;
            return quantity;
        }
        return 0;
    }

    public void adjustQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantityAvailable = quantity;
        }
    }   //  Adjusting Available Quantity

    @Override
    public int hashCode() {
        return this.name.hashCode() + 12;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((ShoppingItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public String toString() {
        return this.name + ": price: " + this.price;
    }

    @Override
    public int compareTo(ShoppingItem o) {
        if (this == o) {
            return 0;
        }
        if (o != null) {
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();
    }
}
