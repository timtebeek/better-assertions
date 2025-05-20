package com.github.timtebeek.betterassertions.review;

import com.github.timtebeek.betterassertions.Book;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void test() {
        Book book = new Book(
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                1925);
        assertEquals("The Great Gatsby", book.getTitle());
    }
}
