package com.github.timtebeek.betterassertions.assertj;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.assertj.provider.BookTester;
import com.github.timtebeek.betterassertions.Bundle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AssertThatBookTest {

    @Test
    void bookAssertions() {
        BookTester bookTester = BookTester.of(new Book("Effective Java", "Joshua Bloch", 2001));
        assertThat(bookTester)
                .isNotNull()
                .title().contains("Effective");
        assertThat(bookTester).author().contains("Bloch");
        assertThat(bookTester).year().isLessThan(2003);
    }

    @Test
    void bookCollectionAssertions() {
        assertThat(new Bundle().getBooks())
                .map(BookTester::of)
                .allSatisfy(book -> assertThat(book).year().isBetween(1999, 2010));
    }
}
