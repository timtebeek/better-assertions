package com.github.timtebeek.betterassertions.assertj.provider;

import com.github.timtebeek.betterassertions.Book;
import org.assertj.core.api.*;

public class BookTester extends AbstractObjectAssert<BookTester, Book> implements AssertProvider<BookTester> {

    private final Book book;

    private BookTester(Book book) {
        super(book, BookTester.class);
        this.book = book;
    }

    public static BookTester of(Book book) {
        return new BookTester(book);
    }

    @Override
    public BookTester assertThat() {
        return new BookTester(book);
    }

    public AbstractStringAssert<?> author() {
        return Assertions.assertThat(book.getAuthor()).describedAs("author");
    }

    public AbstractStringAssert<?> title() {
        return Assertions.assertThat(book.getTitle()).describedAs("title");
    }

    public AbstractIntegerAssert<?> year() {
        return Assertions.assertThat(book.getYear()).describedAs("year");
    }
}
