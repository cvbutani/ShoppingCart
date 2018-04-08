package com.company.example;

public class Main {
    private static StockIist stocklist = new StockIist();

    public static void main(String[] args) {
        ShoppingItem item = new ShoppingItem("Bread", 100, 2.99);
        stocklist.addStock(item);
        item = new ShoppingItem("Milk", 250, 4.27);
        stocklist.addStock(item);
        item = new ShoppingItem("Juice", 50, 1.99);
        stocklist.addStock(item);
        item = new ShoppingItem("Egg", 10, 3.54);
        stocklist.addStock(item);
        item = new ShoppingItem("Chocolate", 500, 0.77);
        stocklist.addStock(item);
        item = new ShoppingItem("Coffee", 5, 6);
        stocklist.addStock(item);
        item = new ShoppingItem("Table", 15, 57.99);
        stocklist.addStock(item);
        item = new ShoppingItem("Chair", 15, 65.97);
        stocklist.addStock(item);
        item = new ShoppingItem("TV", 20, 999.99);
        stocklist.addStock(item);

     //   System.out.println(stocklist);

        Basket myBasket = new Basket("No Frills");

        sellItem(myBasket,"Bread", 2);
        sellItem(myBasket,"Chair", 2);
        sellItem(myBasket,"TV", 1);
        sellItem(myBasket,"Mobile", 2);
        sellItem(myBasket,"Egg", 4);
        sellItem(myBasket,"Table", 1);
        sellItem(myBasket,"Milk", 3);
        sellItem(myBasket,"Chocolate", 15);
        sellItem(myBasket,"Juice", 10);
        sellItem(myBasket,"Coffee", 4);
        sellItem(myBasket,"laptop", 5);

        myBasket.checkOut();
        System.out.println(myBasket);
        System.out.println(stocklist);

    }

    private static void sellItem(Basket basket, String name, int quantity) {
        ShoppingItem shop = stocklist.get(name);

        if (shop == null) {
            System.out.println("We don't sell " + name + ".");
        }
        if (stocklist.reserveItem(name, quantity) >= 0) {
            basket.addToBasket(shop, quantity);
        }
    }
}