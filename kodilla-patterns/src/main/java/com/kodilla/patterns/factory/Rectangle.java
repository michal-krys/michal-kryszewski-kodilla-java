package com.kodilla.patterns.factory;

public class Rectangle implements Shape {

    private final String name;
    private final double width;
    private final double height;

    public Rectangle(final String name, final double width, final double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getCircumference() {
        return 2 * width + 2 * height;
    }
}
