package com.kodilla.patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeFactoryTestSuite {

    @Test
    void testFactoryCircle() {
        //given
        ShapeFactory shapeFactory = new ShapeFactory();
        //when
        Shape circle = shapeFactory.makeShape(ShapeFactory.CIRCLE);
        //then
        assertEquals(Math.PI * Math.pow(4.5, 2.0), circle.getArea(), 0);
        assertEquals("The rounded circle", circle.getName());
    }

    @Test
    void testFactorySquare() {
        //given
        ShapeFactory shapeFactory = new ShapeFactory();
        //when
        Shape square = shapeFactory.makeShape(ShapeFactory.SQUARE);
        //then
        assertEquals(28, square.getCircumference(), 0);
        assertEquals("The angular square", square.getName());
    }

    @Test
    void testFactoryRectangle() {
        //given
        ShapeFactory shapeFactory = new ShapeFactory();
        //when
        Shape rectangle = shapeFactory.makeShape(ShapeFactory.RECTANGLE);
        //then
        assertEquals(37.5, rectangle.getArea(), 0);
        assertEquals("The long rectangle", rectangle.getName());
    }
}
