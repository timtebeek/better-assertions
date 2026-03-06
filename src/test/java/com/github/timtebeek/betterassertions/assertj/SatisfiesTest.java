package com.github.timtebeek.betterassertions.assertj;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.assertj.provider.BookTester;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SatisfiesTest {

    Book book = new Book("Effective Java", "Joshua Bloch", 2001);

    @Test
    void bookAssertions() {
        // Verify all conditions before optionally failing and reporting
        assertThat(book)
                .satisfies(
                        b -> BookTester.of(b).title().contains("Effective"),
                        b -> BookTester.of(b).author().contains("Bloch"),
                        b -> BookTester.of(b).year().isLessThan(2003)
                );
    }

    @Disabled
    @Test
    void faultyBookAssertions() {
        // Verify all conditions before optionally failing and reporting
        assertThat(book)
                .satisfies(
                        b -> BookTester.of(b).title().contains("Ineffective"),
                        b -> BookTester.of(b).author().contains("Blag"),
                        b -> BookTester.of(b).year().isEven()
                );
    }
}
