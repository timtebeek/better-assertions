package com.github.timtebeek.betterassertions.junit4;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.Bundle;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class JUnitFourTest { // Requires public modifier

    @Test
    public void bundle() { // Can be any name, but has to be public
        List<Book> books = new Bundle().getBooks();

        assertNotNull(books);
        assertEquals(3, books.size());
        assertTrue(books.contains(new Book("Effective Java", "Joshua Bloch", 2001)));
        assertTrue(books.contains(new Book("Java Concurrency in Practice", "Brian Goetz", 2006)));
        assertTrue(books.contains(new Book("Clean Code", "Robert C. Martin", 2008)));
        assertFalse(books.contains(new Book("Java 8 in Action", "Raoul-Gabriel Urma", 2014)));

        String expectedTitle = books.get(0).getTitle();
        assertNotNull("Title not null", expectedTitle);
        assertEquals("Title should match", "Effective Java", expectedTitle);
    }


    // Test passes, but the assertions are incorrect!
    @Test
    public void incorrectArgumentOrder() {
        String expectedTitle = new Bundle().getBooks().get(0).getTitle();
        assertNotNull(expectedTitle, "Title not null");
        assertEquals("Title should match", expectedTitle, "Effective Java");
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    // Exception thrown by the test
    @Test
    public void expectException() throws IllegalArgumentException{
        int i = 1 + 2;
        Assertions.assertEquals(i, 3);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("boom!");
        boom();
    }

    private void boom() {
        throw new IllegalArgumentException("boom!");
    }
}
