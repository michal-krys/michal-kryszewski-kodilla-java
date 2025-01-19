package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //when
        board.getToDoList().addTask("Do the dishes");
        board.getInProgressList().addTask("Polish the handrails");
        board.getDoneList().addTask("Wipe the dust");
        String resultToDo = board.getToDoList().getTasks().toString();
        String resultInProgress = board.getInProgressList().getTasks().toString();
        String resultDone = board.getDoneList().getTasks().toString();

        //then
        assertEquals("[Do the dishes]", resultToDo);
        assertEquals("[Polish the handrails]", resultInProgress);
        assertEquals("[Wipe the dust]", resultDone);
    }

    @Test
    void testShowTasks() {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getToDoList().addTask("Clean the floors");
        board.getInProgressList().addTask("Clean the windows");
        board.getDoneList().addTask("Take out the trash");

        //when
        String result = board.showTasks();

        //then
        assertEquals("To Do: [Clean the floors]\n" +
                "In progress: [Clean the windows]\n" +
                "Done: [Take out the trash]", result);
    }
}
