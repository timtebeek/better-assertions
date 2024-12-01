package com.github.timtebeek.betterassertions;

import java.util.List;

public class Bundle {
    public List<Book> getBooks() {
        return List.of(
                new Book("Effective Java", "Joshua Bloch", 2001),
                new Book("Java Concurrency in Practice", "Brian Goetz", 2006),
                new Book("Clean Code", "Robert C. Martin", 2008)
        );
    }
}
