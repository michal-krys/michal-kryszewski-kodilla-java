package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    Statistics statistics = mock(Statistics.class);

    @Test
    void test0PostCount(){
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            usersList.add(String.valueOf(i));
        }
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.postsCount()).thenReturn(0);
        when(statistics.commentsCount()).thenReturn(100);
        //When
        advancedStatistics.calculateAdvStatistics(statistics);
        //Then
        assertEquals(0,advancedStatistics.getPostCount());
        assertEquals(0,advancedStatistics.getMeanPostsPerUser());
        assertEquals(0,advancedStatistics.getMeanCommentsPerPost());
    }

    @Test
    void test1000PostCount(){
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            usersList.add(String.valueOf(i));
        }
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.commentsCount()).thenReturn(5600);
        //When
        advancedStatistics.calculateAdvStatistics(statistics);
        //Then
        assertEquals(1000,advancedStatistics.getPostCount() );
        assertEquals(5,advancedStatistics.getMeanPostsPerUser() );
        assertEquals(5.6,advancedStatistics.getMeanCommentsPerPost() );
    }

    @Test
    void test0CommentCount(){
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            usersList.add(String.valueOf(i));
        }
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.postsCount()).thenReturn(100);
        when(statistics.commentsCount()).thenReturn(0);
        //When
        advancedStatistics.calculateAdvStatistics(statistics);
        //Then
        assertEquals(0,advancedStatistics.getCommentCount());
        assertEquals(0,advancedStatistics.getMeanCommentsPerUser());
        assertEquals(0,advancedStatistics.getMeanCommentsPerPost());
    }

    @Test
    void test1000CommentCount(){
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        List<String> usersList = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            usersList.add(String.valueOf(i));
        }
        when(statistics.userNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(1000);
        when(statistics.postsCount()).thenReturn(800);
        //When
        advancedStatistics.calculateAdvStatistics(statistics);
        //Then
        assertEquals(1000,advancedStatistics.getCommentCount());
        assertEquals(5,advancedStatistics.getMeanCommentsPerUser() );
        assertEquals(1.25,advancedStatistics.getMeanCommentsPerPost() );
    }

    @Test
    void testMorePostsThanComms() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        when(statistics.postsCount()).thenReturn(10);
        when(statistics.commentsCount()).thenReturn(5);
        //When
        advancedStatistics.calculateAdvStatistics(statistics);
        //Then
        assertEquals(0.5, advancedStatistics.getMeanCommentsPerPost());
    }

    @Test
    void testMoreCommsThanPosts() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        when(statistics.postsCount()).thenReturn(5);
        when(statistics.commentsCount()).thenReturn(10);
        //When
        advancedStatistics.calculateAdvStatistics(statistics);
        //Then
        assertEquals(2, advancedStatistics.getMeanCommentsPerPost());
    }

    @Test
    void test0UserCount() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        List<String> noUsers = new ArrayList<>();
        when(statistics.userNames()).thenReturn(noUsers);
        //When
        advancedStatistics.calculateAdvStatistics(statistics);
        //Then
        assertEquals(0,advancedStatistics.getUserCount());
        assertEquals(0,advancedStatistics.getMeanPostsPerUser());
        assertEquals(0,advancedStatistics.getMeanCommentsPerUser());
    }

    @Test
    void test1000UserCount() {
        //Given
        AdvancedStatistics advancedStatistics = new AdvancedStatistics();
        List<String> a1000UsersList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            a1000UsersList.add(String.valueOf(i));
        }
        when(statistics.userNames()).thenReturn(a1000UsersList);
        when(statistics.postsCount()).thenReturn(300);
        when(statistics.commentsCount()).thenReturn(500);
        //When
        advancedStatistics.calculateAdvStatistics(statistics);
        //Then
        assertEquals(1000,advancedStatistics.getUserCount() );
        assertEquals(0.3,advancedStatistics.getMeanPostsPerUser() );
        assertEquals(0.5,advancedStatistics.getMeanCommentsPerUser() );
    }
}