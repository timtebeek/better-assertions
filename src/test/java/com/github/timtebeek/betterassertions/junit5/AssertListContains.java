package com.github.timtebeek.betterassertions.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AssertListContains {

    List<String> list = List.of("a", "b", "c");

    @Test
    void assertMultipleElements() {
        assertTrue(list.contains("a"));
        assertTrue(list.contains("b"));
        assertTrue(list.contains("c"));
    }

    @Disabled
    @Test
    void assertMultipleElementsFails() {
        assertTrue(list.contains("a"));
        assertTrue(list.contains("E"));
        assertTrue(list.contains("c"));
    }
}
