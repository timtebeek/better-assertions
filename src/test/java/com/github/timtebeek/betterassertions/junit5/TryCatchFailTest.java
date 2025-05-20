package com.github.timtebeek.betterassertions.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class TryCatchFailTest {

    @Test
    void tryCatchFail() {
        try {
            boom();
            fail("Exception uncaught");
        } catch (IllegalStateException e) {
            assertTrue(true, "Exception caught");
        }
    }

    private void boom() {
        throw new IllegalStateException("boom!");
    }
}
