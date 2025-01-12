package com.kodilla.good.patterns.challanges.fooddeliveryservice;

public class Product {

    private String type;
    private int quantity;
    private double price;

    public Product(String type, int quantity, double price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
