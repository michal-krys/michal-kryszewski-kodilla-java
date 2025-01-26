package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void loggerInit() {
        logger = Logger.INSTANCE;
        logger.log("Test log 1");
    }

    @Test
    void testGetLastLog() {
        //given
        //when
        String result = logger.getLastLog();
        //then
        assertEquals("Test log 1", result);
    }
}
