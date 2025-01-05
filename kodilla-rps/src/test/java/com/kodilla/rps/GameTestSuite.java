package com.kodilla.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTestSuite {

    @Test
    void testRockBeatsScissors() {
        //Given
        Game game = new Game(3);
        Move rock = new Move("Rock", 1);
        Move scissors = new Move("Scissors", 3);

        //When
        game.run(rock, scissors);

        //Then
        assertEquals(1, game.getPlayerScore());
        assertEquals(0, game.getComputerScore());
    }

    @Test
    void testPaperBeatsRock() {
        //Given
        Game game = new Game(3);
        Move paper = new Move("Paper", 2);
        Move rock = new Move("Rock", 1);
        //When
        game.run(paper, rock);
        //Then
        assertEquals(1, game.getPlayerScore());
        assertEquals(0, game.getComputerScore());
    }

    @Test
    void testScissorsBeatsPaper() {
        //Given
        Game game = new Game(3);
        Move scissors = new Move("Scissors", 3);
        Move paper = new Move("Paper", 2);

        //When
        game.run(scissors, paper);

        //Then
        assertEquals(1, game.getPlayerScore());
        assertEquals(0, game.getComputerScore());
    }

    @Test
    void testScissorsTie() {
        //Given
        Game game = new Game(3);
        Move scissors = new Move("Scissors", 3);

        //When
        game.run(scissors, scissors);

        //Then
        assertEquals(0, game.getPlayerScore());
        assertEquals(0, game.getComputerScore());
    }

    @Test
    void testPaperTie() {
        //Given
        Game game = new Game(3);
        Move paper = new Move("Paper", 2);

        //When
        game.run(paper, paper);

        //Then
        assertEquals(0, game.getPlayerScore());
        assertEquals(0, game.getComputerScore());
    }

    @Test
    void testRockTie() {
        //Given
        Game game = new Game(3);
        Move rock = new Move("Rock", 1);

        //When
        game.run(rock, rock);

        //Then
        assertEquals(0, game.getPlayerScore());
        assertEquals(0, game.getComputerScore());
    }

    @Test
    void testPlayerWinsTheGame() {
        //Given
        int winningScore = 3;
        Game game = new Game(winningScore);
        Move playerMove = new Move("Rock", 1);
        Move computerMove = new Move("Scissors", 3);

        //When
        game.run(playerMove, computerMove);
        game.run(playerMove, computerMove);
        game.run(playerMove, computerMove);

        //Then
        assertEquals(winningScore, game.getPlayerScore());
        assertEquals(0, game.getComputerScore());
    }

    @Test
    void testComputerWinsTheGame() {
        //Given
        int winningScore = 3;
        Game game = new Game(winningScore);
        Move playerMove = new Move("Rock", 1);
        Move computerMove = new Move("Paper", 2);

        //When
        game.run(playerMove, computerMove);
        game.run(playerMove, computerMove);
        game.run(playerMove, computerMove);

        //Then
        assertEquals(0, game.getPlayerScore());
        assertEquals(winningScore, game.getComputerScore());
    }

    @Test
    void testPlayerResetScore() {
        //Given
        int winningScore = 4;
        Game game = new Game(winningScore);
        Move playerMove = new Move("Rock", 1);
        Move computerMove = new Move("Scissors", 3);

        //When
        game.run(playerMove, computerMove);
        game.run(playerMove, computerMove);
        game.run(playerMove, computerMove);

        assertEquals(3, game.getPlayerScore());
        game.reset(game.getPlayerScore());

        //Then
        assertEquals(0, game.getPlayerScore());
    }

    @Test
    void testComputerResetScore() {
        //Given
        int winningScore = 4;
        Game game = new Game(winningScore);
        Move playerMove = new Move("Rock", 1);
        Move computerMove = new Move("Paper", 2);

        //When
        game.run(playerMove, computerMove);
        game.run(playerMove, computerMove);
        game.run(playerMove, computerMove);

        assertEquals(3, game.getComputerScore());
        game.reset(game.getComputerScore());

        //Then
        assertEquals(0, game.getComputerScore());
    }
}
