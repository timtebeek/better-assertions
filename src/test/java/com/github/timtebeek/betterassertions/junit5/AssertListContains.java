package com.github.timtebeek.betterassertions.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AssertListContains {

    List<String> list = List.of("a", "b", "c");

    @Test
    void assertListSize() {
        assertTrue(list.contains("b"));
    }

    @Disabled
    @Test
    void assertListSizeFails() {
        assertTrue(list.contains("E"));
    }
}
