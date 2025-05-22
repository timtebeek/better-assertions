package com.github.timtebeek.betterassertions.junit5;

import com.github.timtebeek.betterassertions.Bundle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextBlockTest {
    @Test
    void summary() {
        String summary = new Bundle().summary();
        assertEquals("Books:\n" +
                        "Effective Java by Joshua Bloch (2001)\n" +
                        "Java Concurrency in Practice by Brian Goetz (2006)\n" +
                        "Clean Code by Robert C. Martin (2008)\n" +
                        "Authors:\n" +
                        "Joshua Bloch\n" +
                        "Brian Goetz\n" +
                        "Robert C. Martin\n" +
                        "Total books: 3\n" +
                        "Total authors: 3\n",
                summary);
    }
}
