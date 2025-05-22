package com.github.timtebeek.betterassertions.assertj;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.Bundle;
import com.github.timtebeek.betterassertions.assertj.provider.BookTester;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AssertThatBookTest {

    @Test
    void bookAssertions() {
        BookTester bookTester = BookTester.of(new Book("Effective Java", "Joshua Bloch", 2001));

        // Compose assertions on named properties
        assertThat(bookTester).title().contains("Effective");
        assertThat(bookTester).author().contains("Bloch");
        assertThat(bookTester).year().isLessThan(2003);

        // Or alternatively, match exactly
        assertThat(bookTester)
                .hasTitle("Effective Java")
                .hasAuthor("Joshua Bloch")
                .hasYear(2001);
    }

    @Test
    void bookCollectionAssertions() {
        assertThat(new Bundle().getBooks())
                .map(BookTester::of)
                .allSatisfy(book -> assertThat(book).year().isBetween(1999, 2010));
    }
}
