package com.github.timtebeek.betterassertions.assertj;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.assertj.softly.SoftBookAssertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AssertSoftlyTest {

    Book book = new Book("Effective Java", "Joshua Bloch", 2001);

    @Test
    void softAssertions() {
        // Verify all conditions before optionally failing and reporting
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(book.getTitle()).as("title").contains("Effective");
            softly.assertThat(book.getAuthor()).as("author").contains("Bloch");
            softly.assertThat(book.getYear()).as("year").isLessThan(2003);
        });
    }

    @Test
    void softBookAssertions() {
        // Leverage SoftBookAssertions for named properties
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
        // Illustrate multiple failures being reported
        try (SoftBookAssertions softly = new SoftBookAssertions(book)) {
            softly.title()
                    .isNotNull()
                    .contains("Ineffective");
            softly.author().contains("Blog");
            softly.year().isEven();
        }
    }
}
