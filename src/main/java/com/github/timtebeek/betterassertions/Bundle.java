package com.github.timtebeek.betterassertions;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Bundle {
    public List<Book> getBooks() {
        return List.of(
                new Book("Effective Java", "Joshua Bloch", 2001),
                new Book("Java Concurrency in Practice", "Brian Goetz", 2006),
                new Book("Clean Code", "Robert C. Martin", 2008)
        );
    }

    public List<String> getAuthors() {
        List<Book> books = getBooks();
//        Book first = books.get(0);
//        Book first = books.getFirst();
        return books.stream()
                .map(Book::getAuthor)
                .collect(toList());
    }

    public String summary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Books:\n");
        for (Book book : getBooks()) {
            summary.append(book.getTitle())
                    .append(" by ")
                    .append(book.getAuthor())
                    .append(" (")
                    .append(book.getYear())
                    .append(")\n");
        }
        summary.append("Authors:\n");
        for (String author : getAuthors()) {
            summary.append(author).append("\n");
        }
        summary.append("Total books: ").append(getBooks().size()).append("\n");
        summary.append("Total authors: ").append(getAuthors().size()).append("\n");
        return summary.toString();
    }
}
