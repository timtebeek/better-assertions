package com.github.timtebeek.betterassertions.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class TryCatchFailTest {

    @Test
    void expectException() {
        try {
            boom();
            fail("Exception uncaught");
        } catch (IllegalStateException e) {
            // Catch before fail is called
        }
    }

    @Test
    void expectNoException() {
        try {
            noBoom();
            assertTrue(true, "No Exception");
        } catch (IllegalStateException e) {
            fail("Exception caught");
        }
    }

    private void noBoom() {
    }

    private void boom() {
        throw new IllegalStateException("boom!");
    }
}
