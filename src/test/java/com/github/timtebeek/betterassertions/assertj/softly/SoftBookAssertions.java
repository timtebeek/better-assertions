package com.github.timtebeek.betterassertions.assertj.softly;

import com.github.timtebeek.betterassertions.Book;
import org.assertj.core.api.AutoCloseableSoftAssertions;
import org.assertj.core.api.IntegerAssert;
import org.assertj.core.api.StringAssert;

public class SoftBookAssertions extends AutoCloseableSoftAssertions {

    private final Book book;

    public SoftBookAssertions(Book book) {
        this.book = book;
    }

    public StringAssert title(){
        return assertThat(book.getTitle()).describedAs("title");
    }

    public StringAssert author(){
        return assertThat(book.getAuthor()).describedAs("author");
    }

    public IntegerAssert year(){
        return assertThat(book.getYear()).describedAs("year");
    }
}
