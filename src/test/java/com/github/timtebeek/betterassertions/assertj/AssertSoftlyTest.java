package com.github.timtebeek.betterassertions.assertj;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.assertj.softly.SoftBookAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AssertSoftlyTest {

    Book book = new Book("Effective Java", "Joshua Bloch", 2001);

    @Test
    void bookAssertions() {
        // Verify all conditions before optionally failing and reporting
        try (SoftBookAssertions softly = new SoftBookAssertions(book)) {
            softly.title()
                    .isNotNull()
                    .contains("Effective");
            softly.author().contains("Bloch");
            softly.year().isLessThan(2003);
        }
    }

    @Disabled
    @Test
    void faultyBookAssertions() {
        // Verify all conditions before optionally failing and reporting
        try (SoftBookAssertions softly = new SoftBookAssertions(book)) {
            softly.title()
                    .isNotNull()
                    .contains("Ineffective");
            softly.author().contains("Blog");
            softly.year().isEven();
        }
    }
}
