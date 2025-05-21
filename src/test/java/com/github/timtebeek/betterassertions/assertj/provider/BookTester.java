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

    // Delegating matchers
    public AbstractStringAssert<?> author() {
        return Assertions.assertThat(book.getAuthor()).describedAs("author");
    }

    public AbstractStringAssert<?> title() {
        return Assertions.assertThat(book.getTitle()).describedAs("title");
    }

    public AbstractIntegerAssert<?> year() {
        return Assertions.assertThat(book.getYear()).describedAs("year");
    }

    // Exact matches
    public BookTester hasAuthor(String author) {
        assertThat()
                .isNotNull()
                .author()
                .describedAs("author")
                .isEqualTo(author);
        return myself;
    }

    public BookTester hasTitle(String title) {
        assertThat()
                .isNotNull()
                .title()
                .describedAs("title")
                .isEqualTo(title);
        return myself;
    }

    public BookTester hasYear(int year) {
        assertThat()
                .isNotNull()
                .year()
                .describedAs("year")
                .isEqualTo(year);
        return myself;
    }
}
