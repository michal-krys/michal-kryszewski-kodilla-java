package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeTests() {
        System.out.println("Test suite started");
    }

    @AfterAll
    public static void afterTests() {
        System.out.println("Test suite finished");
    }

    @BeforeEach
    public void beforeEachTest() {
        testCounter++;
        System.out.println("Test #" + testCounter + " started");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("Test #" + testCounter + " finished");
    }

    @Nested
    @DisplayName("Tests for adding/removing figures from the list:")
    class TestsAddRemove {

        @Test
        void testAddFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("circle1", 25);
            //When
            shapeCollector.addFigure(circle);
            //Then
            assertEquals(1, shapeCollector.size());
        }

        @Test
        void testRemoveFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("circle1", 25);
            shapeCollector.addFigure(circle);
            //When
            boolean result = shapeCollector.removeFigure(circle);
            //Then
            assertTrue(result);
            assertEquals(0, shapeCollector.size());
        }
    }

    @Nested
    @DisplayName("Tests for figures data acquisition:")
    class TestsShapesData {

        @Test
        void testGetFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("circle1", 25);
            shapeCollector.addFigure(circle);
            //When
            Shape retrievedShape;
            retrievedShape = shapeCollector.getFigure(0);
            //Then
            assertEquals(circle, retrievedShape);
        }

        @Test
        void testShowFigures(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("circle1", 25);
            Shape square = new Square("square1", 25);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            //When
            String result = shapeCollector.showFigures();
            //Then
            assertEquals("circle1, square1", result);
        }
    }
}
