package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AssertionsTest {

    @Test
    void testAssertions() {

        // Check if values are equal
        assertEquals(5, 2 + 3);

        // Check if condition is true
        assertTrue(10 > 5);

        // Check if condition is false
        assertFalse(5 > 10);

        // Check if value is null
        String name = null;
        assertNull(name);

        // Check if object is not null
        Object obj = new Object();
        assertNotNull(obj);
    }
}
