package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of the tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @org.junit.jupiter.api.Nested
    @DisplayName("Test for posts:")
    class TestPosts {
        @Test
        void testAddPost(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            //When
            forumUser.addPost("mrsmith", "Hello everyone, this is my first contribution here!");
            //Then
            assertEquals(1, forumUser.getPostsQuantity());
        }

        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getPostBody(), thePost.getAuthor());
            //When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);
            //Then
            assertEquals(thePost, retrievedPost);
        }

        @Test
        void testRemovePostNotExisiting(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            assertFalse(result);
        }

        @Test
        void testRemovePost(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getPostBody(), thePost.getAuthor());
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            assertTrue(result);
            assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @org.junit.jupiter.api.Nested
    @DisplayName("Tests for comments:")
    class TestComments {
        @Test
        void testAddComment(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            //When
            forumUser.addComment(thePost, "mrsmith", "Thank you all for good words!");
            //Then
            assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you all for good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());
            //When

            //Then
        }

        @Test
        void testRemoveCommentNotExisiting(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you all for good words!");
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            assertFalse(result);
        }

        @Test
        void testRemoveComment(){
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you all for good words!");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            assertTrue(result);
            assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}