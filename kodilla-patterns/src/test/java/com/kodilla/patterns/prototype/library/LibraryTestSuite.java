package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //given
        Library library = new Library("Library");
        IntStream.iterate(1, i -> i + 1)
                        .limit(5)
                        .forEach(i -> library.getBooks().add(new Book("Book " + i,
                                "John Doe " + i, LocalDate.now().plusYears(i))));

        Library shallowCopiedLibrary = null;
        try {
            shallowCopiedLibrary = library.shallowCopy();
            shallowCopiedLibrary.setName("Shallow copied library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepCopiedLibrary = null;
        try {
            deepCopiedLibrary = library.deepCopy();
            deepCopiedLibrary.setName("Deep copied library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //when
        library.getBooks().add(new Book("New book", "John Doe Boe", LocalDate.now()));

        //then
        System.out.println(library);
        System.out.println(shallowCopiedLibrary);
        System.out.println(deepCopiedLibrary);
        assertEquals(6, library.getBooks().size());
        assertEquals(6, shallowCopiedLibrary.getBooks().size());
        assertEquals(5, deepCopiedLibrary.getBooks().size());
        assertEquals(library.getBooks(), shallowCopiedLibrary.getBooks());
        assertNotEquals(library.getBooks(), deepCopiedLibrary.getBooks());
    }
}
