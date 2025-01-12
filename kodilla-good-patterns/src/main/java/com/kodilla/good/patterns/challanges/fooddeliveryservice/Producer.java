package com.kodilla.good.patterns.challanges.fooddeliveryservice;

public class Producer implements OrdersProcessor {

    private String name;

    public Producer(String name, Product product) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void processOrder() {
        System.out.println("Producer " + name + " is processing your order.");
    }

}
