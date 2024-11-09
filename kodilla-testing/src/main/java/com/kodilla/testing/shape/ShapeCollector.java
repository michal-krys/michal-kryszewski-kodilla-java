package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {

    List<Shape> shapeCollector = new ArrayList<>();

    public int size() {
        return shapeCollector.size();
    }

    public void addFigure(Shape shape) {
        shapeCollector.add(shape);
    }

    public boolean removeFigure (Shape shape){
        boolean result = false;
        if(shapeCollector.remove(shape)){
            result = true;
        }
        return result;
    }

    public Shape getFigure(int shapeNumber){
        if(shapeNumber >= 0 && shapeNumber < shapeCollector.size()){
            return shapeCollector.get(shapeNumber);
        }
        return null;
    }

    public String showFigures(){
        StringBuilder result = new StringBuilder();
        for(Shape shape : shapeCollector){
            result.append(shape.getShapeName()).append(", ");
        }
        if(result.length() > 0){
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}