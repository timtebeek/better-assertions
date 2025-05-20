package com.github.timtebeek.betterassertions.junit5;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.Bundle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JUnitJupiterTest {

    // JUnit Jupiter
    // + Reduced visibility of classes and methods
    // + Improved assertion messages

    @Test
    void bundle() {
        List<Book> books = new Bundle().getBooks();

        assertNotNull(books);
        assertEquals(3, books.size());
        assertTrue(books.contains(new Book("Effective Java", "Joshua Bloch", 2001)));
        assertTrue(books.contains(new Book("Java Concurrency in Practice", "Brian Goetz", 2006)));
        assertTrue(books.contains(new Book("Clean Code", "Robert C. Martin", 2008)));
        assertFalse(books.contains(new Book("Java 8 in Action", "Raoul-Gabriel Urma", 2014)));

        Book book = books.get(0);
        assertEquals("Effective Java", book.getTitle(), "Title should match");
    }

    // Test passes, but the assertions are incorrect!
    @Test
    void incorrectArgumentOrder() {
        String expectedTitle = new Bundle().getBooks().get(0).getTitle();
        assertNotNull("Title not null", expectedTitle);
        assertEquals(expectedTitle, "Effective Java", "Title should match");
    }

    // Exception thrown by the test
    @Test
    void expectException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            int i = 1 + 2;
            assertEquals(i, 3);
            boom();
        });
        assertEquals("boom!", ex.getMessage());
    }

    private void boom() {
        throw new IllegalArgumentException("boom!");
    }

    // Missing @Nested annotation
    class InnerClass {
        @Test
        void innerClass() {
            assertTrue(true);
        }
    }

}
