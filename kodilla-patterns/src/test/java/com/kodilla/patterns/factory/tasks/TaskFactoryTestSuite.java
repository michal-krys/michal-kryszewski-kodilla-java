package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShopping() {
        //given
        TaskFactory taskFactory = new TaskFactory();
        //when
        Task shopping = taskFactory.getTask(TaskFactory.SHOPPING);
        shopping.executeTask();
        //then
        assertEquals("Groceries", shopping.getTaskName());
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryDriving() {
        //given
        TaskFactory taskFactory = new TaskFactory();
        //when
        Task driving = taskFactory.getTask(TaskFactory.DRIVING);
        //then
        assertEquals("Driving", driving.getTaskName());
        assertFalse(driving.isTaskExecuted());
    }

    @Test
    void testFactoryPainting() {
        //given
        TaskFactory taskFactory = new TaskFactory();
        //when
        Task painting = taskFactory.getTask(TaskFactory.PAINTING);
        painting.executeTask();
        //then
        assertEquals("Painting", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }
}
