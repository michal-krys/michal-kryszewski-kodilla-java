package com.kodilla;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class Main {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("Calculating expressions with lambdas: ");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);

        System.out.println(" ");

        System.out.println("Calculating expressions with method references: ");
        expressionExecutor.executeExpression(3,4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3,4, FunctionalCalculator::divideAByB);
        expressionExecutor.executeExpression(3,4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);

        System.out.println(" ");

        System.out.println("Poems bueatified: ");
        poemBeautifier.beautify("To be or not to be, that is the question", (poem) -> poem.toUpperCase());
        poemBeautifier.beautify("To be or not to be, that is the question", (poem) -> poem.toLowerCase());
        poemBeautifier.beautify("To be or not to be, that is the question", (poem) -> "ABC " + poem + " ACB");
        poemBeautifier.beautify("To be or not to be, that is the question", (poem) -> new StringBuilder(poem).reverse().toString());
        poemBeautifier.beautify(" To be or not to be, that is the question ", (poem) -> poem.replace(" ", "*"));

        System.out.println(" ");

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}