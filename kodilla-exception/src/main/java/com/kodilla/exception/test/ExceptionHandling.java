package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(1, 1.5);
            System.out.println("Congratulations, that was good");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("You can always try again ;)");
        }
    }
}
