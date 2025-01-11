package com.kodilla.good.patterns.challanges.orders;

public class OrderRequest {

    private String productName;
    private int quantity;
    private boolean isPayed;

    public OrderRequest(String productName, int quantity, boolean isPayed) {
        this.productName = productName;
        this.quantity = quantity;
        this.isPayed = isPayed;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        this.isPayed = payed;
    }

    public void placeOrder () {

    }
}
