package com.github.timtebeek.betterassertions.assertj;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.Bundle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AssertJTest {

    @Test
    void bundle() {
        List<Book> books = new Bundle().getBooks();

        // Repeated assertions on the same object
        assertThat(books).isNotNull();
        assertThat(books).hasSize(3);
        assertThat(books).contains(new Book("Effective Java", "Joshua Bloch", 2001));
        assertThat(books).contains(new Book("Java Concurrency in Practice", "Brian Goetz", 2006));
        assertThat(books).contains(new Book("Clean Code", "Robert C. Martin", 2008));
        assertThat(books).doesNotContain(new Book("Java 8 in Action", "Raoul-Gabriel Urma", 2014));
    }

    @Test
    void chained() {
        List<Book> books = new Bundle().getBooks();

        // Repeated assertions on the same object
        assertThat(books)
                .isNotNull()
                .hasSize(3)
                .contains(new Book("Effective Java", "Joshua Bloch", 2001))
                .contains(new Book("Java Concurrency in Practice", "Brian Goetz", 2006))
                .contains(new Book("Clean Code", "Robert C. Martin", 2008))
                .doesNotContain(new Book("Java 8 in Action", "Raoul-Gabriel Urma", 2014));
    }

    // `assertThatThrownBy` does not yet retain last statement only
    @Test
    void expectException() {
        assertThatThrownBy(() -> {
            int i = 1 + 2;
            assertThat(i).isEqualTo(3);
            boom();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("boom!");
    }

    private void boom() {
        throw new IllegalArgumentException("boom!");
    }

}
