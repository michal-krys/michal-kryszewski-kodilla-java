package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println("The result of the division is " + result);
        } catch (ArithmeticException e) {
            System.out.println("You tried to divide by zero, change the value of the Divisor");
        } finally {
            System.out.println("Thank you for using First Challenge divider machine!");
            final int size = 6;

            for (int i = size / 2; i < size; i += 2) {
                for (int j = 1; j < size - i; j += 2) {
                    System.out.print(" ");
                } for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                } for (int j = 1; j <= size - i; j++) {
                    System.out.print(" ");
                } for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

            for (int i = size; i >= 1; i--) {
                for (int j = 0; j < size - i; j++) {
                    System.out.print(" ");
                } for (int j = 1; j <= (i * 2) - 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}