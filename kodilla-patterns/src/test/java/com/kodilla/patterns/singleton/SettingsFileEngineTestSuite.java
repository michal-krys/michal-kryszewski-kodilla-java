package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SettingsFileEngineTestSuite {

    private static SettingsFileEngine settingsFileEngine;

    @BeforeAll
    public static void openSettingsFile() {
        settingsFileEngine = SettingsFileEngine.INSTANCE;
        settingsFileEngine.open("myapp.settings");
    }

    @AfterAll
    public static void closeSettingsFile() {
        settingsFileEngine.close();
    }

    @Test
    void testGetFileName() {
        //given
        //when
        String fileName = settingsFileEngine.getFileName();
        System.out.println("Opened: " + fileName);
        //then
        assertEquals("myapp.settings", fileName);
    }

    @Test
    void testLoadSettings() {
        //given
        //when
        boolean result = settingsFileEngine.loadSettings();
        //then
        assertTrue(result);
    }

    @Test
    void testSaveSettings() {
        //given
        //when
        boolean result = settingsFileEngine.saveSettings();
        //then
        assertTrue(result);
    }
}
