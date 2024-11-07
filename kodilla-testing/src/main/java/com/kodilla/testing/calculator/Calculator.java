package com.kodilla.testing.calculator;

public class Calculator {

    private int x;
    private int y;

    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int add() {
        return x + y;
    }

    public int subtract() {
        return x - y;
    }
}
