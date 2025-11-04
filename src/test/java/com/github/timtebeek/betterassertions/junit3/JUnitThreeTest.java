package com.github.timtebeek.betterassertions.junit3;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.Bundle;

import java.util.List;

public class JUnitThreeTest extends junit.framework.TestCase { // Can only extend a single class: TestCase

    // + No Annotations, just plain old JUnit 3
    // - Must start with `test`
    // - Must be `public`
    public void testBundle() {
        List<Book> books = new Bundle().getBooks();

        // Limited assertions, with limited expressiveness
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

    // Overuse of `assertTrue`, `assertFalse` and `assertEquals`
    // - Makes it hard to understand what is being tested, especially when tests fail
    public void disabledTestThatFails() {
        List<Book> books = new Bundle().getBooks();

        assertTrue(books.size() == 2);
        assertTrue(books.size() <= 2);
        assertTrue(books.size() < 2);

        assertFalse(books.size() == 3);
        assertFalse(books.size() <= 3);
        assertFalse(books.size() >= 3);

        assertEquals(books, null);
    }

    // Test passes, but the assertions are incorrect!
    public void testIncorrectArgumentOrder() {
        String actualTitle = new Bundle().getBooks().get(0).getTitle();
        assertNotNull(actualTitle, "Title not null");
        assertEquals("Title should match", actualTitle, "Effective Java");
    }

}
