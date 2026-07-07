package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAdd() {

        Calculator c = new Calculator();

        assertEquals(5, c.add(2, 3));
    }
}
