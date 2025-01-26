package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";

    public final Task getTask(final String taskClass) {
        return switch (taskClass) {
            case SHOPPING -> new ShoppingTask("Groceries", "Potatoes", 3.5);
            case DRIVING -> new DrivingTask("Driving", "Home", "Car");
            case PAINTING -> new PaintingTask("Painting", "House", "Red");
            default -> null;
        };
    }
}
