package com.github.timtebeek.betterassertions;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.api.AssertProvider;
import org.assertj.core.api.IntegerAssert;
import org.assertj.core.api.StringAssert;

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

    public StringAssert author() {
        return new StringAssert(book.getAuthor());
    }

    public StringAssert title() {
        return new StringAssert(book.getTitle());
    }

    public IntegerAssert year() {
        return new IntegerAssert(book.getYear());
    }
}
