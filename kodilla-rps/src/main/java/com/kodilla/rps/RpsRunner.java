package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {

    private static Move yourMove(int reference) {
        switch (reference) {
            case 1: return new Move("Rock", 1);
            case 2: return new Move("Paper", 2);
            case 3: return new Move("Scissors", 3);
            default: throw new IllegalArgumentException("Invalid reference");
        }
    }

    private static Move computerMove(){
        Random rand = new Random();
        int moveRef = rand.nextInt(3) + 1;
        return yourMove(moveRef);
    }

    public static void main(String[] args) {

        boolean end = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println("How many rounds to win?");
        int rounds = sc.nextInt();
        sc.nextLine();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("Hello " + name + " welcome to 'Rock, Paper, Scissors'!" );
        System.out.println(
                "To play 'Rock' enter '1', \n" +
                        "To play 'Paper' enter '2', \n" +
                        "To play 'Scissors' enter '3', \n" +
                        "To cancel enter 'x', \n" +
                        "New game enter 'n'.");

        while (!end) {

            System.out.println("What is your move? ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("x")) {
                System.out.println("Are you sure you want to quit? (yes/no)");
                if (sc.next().equalsIgnoreCase("yes")) {
                    end = true;
                    System.out.println("Thank you for playing!");
                    break;
                } else {
                    continue;
                }
            }

            if (input.equalsIgnoreCase("n")) {
                System.out.println("Are you sure you want to start a new game? (yes/no)");
                if (sc.next().equalsIgnoreCase("yes")) {
                    end = false;
                    System.out.println("Starting new game...");
                    playerScore = 0;
                    computerScore = 0;
                    continue;
                } else {
                    continue;
                }
            }

            int yourMoveRef;
            try {
                yourMoveRef = Integer.parseInt(input);
                if (yourMoveRef < 1 || yourMoveRef > 3) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter 1, 2 or 3.");
                continue;
            }

            Move yourMove = yourMove(yourMoveRef);
            Move computerMove = computerMove();

            System.out.println("Your move:" + yourMove.getName());
            System.out.println("Computer: " + computerMove.getName());

            if (yourMove.beats(computerMove)) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (computerMove.beats(yourMove)) {
                System.out.println("You lost this round!");
                computerScore++;
            } else {
                System.out.println("It's a tie!");
            }

            if(playerScore == rounds) {
                System.out.println("Congratulations " + name + "! You won the game!");
                end = true;
            } else if (computerScore == rounds) {
                System.out.println("Sorry " + name + ", you lost the game!");
                end = true;
            }
        }
    }
}
