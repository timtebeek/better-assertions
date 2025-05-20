package com.github.timtebeek.betterassertions.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AssertListSize {

    List<String> list = List.of("a", "b", "c");

    @Test
    void assertListSize() {
        assertNotNull(list);
        assertEquals(list.size(), 3);
    }

    @Disabled
    @Test
    void assertListSizeFails() {
        assertEquals(list.size(), 4);
    }
}
