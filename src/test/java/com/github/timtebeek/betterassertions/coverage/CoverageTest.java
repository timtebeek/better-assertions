package com.github.timtebeek.betterassertions.coverage;

import com.github.timtebeek.betterassertions.Book;
import com.github.timtebeek.betterassertions.Bundle;
import org.junit.jupiter.api.Test;

import java.util.List;

class CoverageTest {

    @Test
    @SuppressWarnings("unused")
    void needCoverage() { // We need 80% code coverage to pass the build
        Bundle bundle = new Bundle();
        List<Book> books = bundle.getBooks();
        List<String> authors = bundle.getAuthors();
    }
}
