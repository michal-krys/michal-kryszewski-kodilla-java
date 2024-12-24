package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsRunner {

    private static Move yourMove(int reference) {
        return switch (reference) {
            case 1 -> new Move("Rock", 1);
            case 2 -> new Move("Paper", 2);
            case 3 -> new Move("Scissors", 3);
            default -> throw new IllegalArgumentException("Invalid move");
        };
    }

    private static Move computerMove() {
        Random rand = new Random();
        int reference = rand.nextInt(3) + 1;
        return yourMove(reference);
    }

    private static void restartGame(Scanner scanner, Game game) {
        int winningScore;
        do {
            System.out.println("How many rounds to win? (Must be greater than 0)");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive number.");
                scanner.next();
            }
            winningScore = scanner.nextInt();
            if (winningScore <= 0) {
                System.out.println("INVALID INPUT!");
            }
        } while (winningScore <= 0);
        game.reset(winningScore);
        System.out.println("New game started!\n");
    }

    private static void quitGame(Scanner scanner) {
        System.out.println("Are you sure you want to quit? Press y to confirm");
        String confirm = scanner.next();
        if (confirm.equals("y")) {
            System.out.println("Bye!");
            System.exit(0);
        } else {
            System.out.println("Continuing current game.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("What's your name?");
        String playerName = scanner.nextLine();

        Game game = new Game(0);
        restartGame(scanner, game);

        System.out.println("Hello " + playerName + "! \n" +
                "Enter 1 for Rock, 2 for Paper, 3 for Scissors.\n" +
                "Enter n to start a new game.\n" +
                "Enter x to quit.");

        while (gameRunning) {
            System.out.print("Your move: ");
            String userInput = scanner.next();

            if (userInput.equals("n")) {
                System.out.println("Do you want to restart the game? Press y to confirm");
                String confirm = scanner.next();
                if (confirm.equals("y")) {
                    restartGame(scanner, game);
                } else {
                    System.out.println("Continuing current game.");
                }
                continue;
            }

            if (userInput.equals("x")) {
                quitGame(scanner);
                continue;
            }

            try {
                Move playerMove = yourMove(Integer.parseInt(userInput));
                Move compMove = computerMove();

                game.run(playerMove, compMove);
                if (game.checkWinner()) {
                    System.out.println("Press n to play again\n" +
                            "Press x to quit.");
                    String quitOrPlayAgain = scanner.next();
                    if (quitOrPlayAgain.equals("n")) {
                        restartGame(scanner, game);
                    } else if (quitOrPlayAgain.equals("x")) {
                        System.out.println("Thank You for playing!\n" +
                                "      Bye! :)");
                        gameRunning = false;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}