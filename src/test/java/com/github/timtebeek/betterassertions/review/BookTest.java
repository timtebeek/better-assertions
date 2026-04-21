package com.github.timtebeek.betterassertions.review;

import com.github.timtebeek.betterassertions.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void test() {
        Book book = new Book(
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                1925);

        Assertions.assertEquals("The Great Gatsby", book.getTitle());
    }
}
