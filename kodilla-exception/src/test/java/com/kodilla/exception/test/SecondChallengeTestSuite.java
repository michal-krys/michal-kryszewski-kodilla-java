package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testProbDoesntThrowException() throws Exception {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when&then
        assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.5, 1.3));
    }

    @Test
    void testProbThrowsException() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when&then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.1, 1.3)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.8, 0))

        );
    }

    @Test
    void testLimitValues() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();
        //when&then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 0)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 0))
        );
    }
}
