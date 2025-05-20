package com.github.timtebeek.betterassertions.hamcrest;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.Bundle;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

class HamcrestTest {

    // Hamcrest
    // - Requires various static imports; harder to discover the available matchers
    // + Allows for writing custom matchers, as the Spring team has done

    @Test
    void bundle() {
        List<Book> books = new Bundle().getBooks();

        assertThat(books, is(not(nullValue())));
        assertThat(books, hasSize(3));
        assertThat(books, hasItem(new Book("Effective Java", "Joshua Bloch", 2001)));
        assertThat(books, hasItem(new Book("Java Concurrency in Practice", "Brian Goetz", 2006)));
        assertThat(books, hasItem(new Book("Clean Code", "Robert C. Martin", 2008)));
        assertThat(books, not(hasItem(new Book("Java 8 in Action", "Raoul-Gabriel Urma", 2014))));
    }


    // Incorrect usage of Hamcrest
    // - First case passes; second and third cases fail
    @Disabled
    @Test
    void failingTest() {
        List<Book> books = new Bundle().getBooks();

        assertThat(books, contains(new Book("Effective Java", "Joshua Bloch", 2001)));
        assertThat(books, contains(new Book("Java Concurrency in Practice", "Brian Goetz", 2006)));
        assertThat(books, contains(new Book("Clean Code", "Robert C. Martin", 2008)));
    }
}
