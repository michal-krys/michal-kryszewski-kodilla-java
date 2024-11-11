package com.kodilla.testing.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;
    private LibraryUser libraryUserMock;
    LibraryUser libraryUserMock2 = mock(LibraryUser.class);

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int i = 0; i < booksQuantity; i++) {
            Book theBook = new Book("Title" + i, "Author" + i, 1970 + i);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Nested
    @DisplayName("Tests for List Books with Condition")
    class ListBooksWithCondition {
        @Test
        void testListBooksWithConditionReturnList() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secret cooking with Alice", "Alice Doe", 1995);
            Book book3 = new Book("Secretive cuisine of Texas: Beef 101", "Bill Barbequson", 2013);
            Book book4 = new Book("Secrets of best sauces: Emulsification", "Jill Dill", 2020);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
            //When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
            //Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
        void testListBooksWithConditionMoreThan20() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("Zero Books")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("Forty Books")).thenReturn(resultListOf40Books);
            //When
            List<Book> theListOf0Books = bookLibrary.listBooksWithCondition("Zero Books");
            List<Book> theListOf15Books = bookLibrary.listBooksWithCondition("Any Title");
            List<Book> theListOf40Books = bookLibrary.listBooksWithCondition("Forty Books");
            //Then
            assertEquals(0, theListOf0Books.size());
            assertEquals(15, theListOf15Books.size());
            assertEquals(0, theListOf40Books.size());
        }

        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            //Given
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            //When
            List<Book> theListOf10Books = bookLibrary.listBooksWithCondition("An");
            //Then
            assertEquals(0, theListOf10Books.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }
    }

    @Nested
    @DisplayName("Tests for List Books in Hands of User")
    class ListBooksInHandsOfUsers {

        @Test
        void test0BooksInHandsOf() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser userWithNoBooks = mock(LibraryUser.class);
            List<Book> resultListOf0Books = new ArrayList<>();
            when(libraryDatabaseMock.listBooksInHandsOf(userWithNoBooks)).thenReturn(resultListOf0Books);
            //When
            List<Book> theListOf0Books = bookLibrary.listBooksInHandsOf(userWithNoBooks);
            //Then
            assertEquals(0, theListOf0Books.size());
        }

        @Test
        void test1BookInHandsOf() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user1Book = mock(LibraryUser.class);
            List<Book> resultListOf1Book = Arrays.asList(new Book("title", "author", 2000));
            when(libraryDatabaseMock.listBooksInHandsOf(user1Book)).thenReturn(resultListOf1Book);
            //When
            List<Book> theListOf1Book = bookLibrary.listBooksInHandsOf(user1Book);
            //Then
            assertEquals(1, theListOf1Book.size());
            assertEquals("title", theListOf1Book.get(0).getTitle());
            assertEquals("author", theListOf1Book.get(0).getAuthor());
            assertEquals(2000, theListOf1Book.get(0).getPublicationYear());
        }

        @Test
        void test5BooksInHandsOf() {
            //Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user5Books = mock(LibraryUser.class);
            List<Book> resultListOf5Book = generateListOfNBooks(5);
            when(libraryDatabaseMock.listBooksInHandsOf(user5Books)).thenReturn(resultListOf5Book);
            //When
            List<Book> theListOf5Book = bookLibrary.listBooksInHandsOf(user5Books);
            //Then
            assertEquals(5, theListOf5Book.size());
        }
    }
}