package com.github.timtebeek.betterassertions.junit5;

import org.junit.jupiter.api.Test;

// Changing just the imports in a migration from JUnit 4 to JUnit 5 is dangerous.
import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.*;

public class ArgumentOrderTest {

    @Test
    void nullableTests() {
        String nullableString = null;
        assertNotNull("Message", "" + nullableString);
        assertNull("Message", nullableString);
    }

    @Test
    void equalsTests() {
        String expected = "expected";
        String actual = "actual";
        assertEquals("Message", "actual", actual);
        assertNotEquals("Message", expected, actual);
    }
}
