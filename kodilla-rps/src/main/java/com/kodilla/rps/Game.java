package com.kodilla.rps;

public class Game {

    private int playerScore = 0;
    private int computerScore = 0;
    private int winningScore = 0;

    public void run(Move yourMove, Move computerMove) {
        System.out.println("Your move: " + yourMove.getName());
        System.out.println("Computer move: " + computerMove.getName());
    
        if (yourMove.beats(computerMove)) {
            System.out.println("You win this round!");
            playerScore++;
        } else if  (computerMove.beats(yourMove)) {
            System.out.println("Computer wins this round!");
            computerScore++;
        } else {
            System.out.println("It's a tie!");
        }
        System.out.println("Score: Player " + playerScore + " - Computer " + computerScore);
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void reset(int winningScore) {
        this.winningScore = winningScore;
        this.playerScore = 0;
        this.computerScore = 0;
    }

    public Game(int winningScore) {
        this.winningScore = winningScore;
    }

    boolean checkWinner() {
        if (playerScore >= winningScore) {
            System.out.println("Congratulations! You won the game!");
            return true;
        } else if (computerScore >= winningScore) {
            System.out.println("Game over! The computer won the game!");
            return true;
        }
        return false;
    }
}
