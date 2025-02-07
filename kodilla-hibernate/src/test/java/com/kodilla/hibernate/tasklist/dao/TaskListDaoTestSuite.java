package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LIST_NAME = "Test List";
    private static final String DESCRIPTION = "Test: Git gud at smth";

    @Test
    void testFindByListName() {
        //given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();
        //when
        List<TaskList> readTaskLists = taskListDao.findByListName(listName);
        //then
        assertEquals(1, readTaskLists.size());
        //cleanUp
        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }
}
