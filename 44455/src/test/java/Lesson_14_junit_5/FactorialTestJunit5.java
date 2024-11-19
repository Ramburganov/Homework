package com.example.factorial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;

public class FactorialTestJunit5 {

    @Test
    public void testFactorialPositive() {
        assertAll("factorial",
                () -> assertEquals(BigInteger.valueOf(120), com.example.factorial.Factorial.calculateFactorial(5)),
                () -> assertEquals(BigInteger.ONE, com.example.factorial.Factorial.calculateFactorial(0)),
                () -> assertEquals(BigInteger.ONE, com.example.factorial.Factorial.calculateFactorial(1))
        );
    }

    @Test
    public void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculateFactorial(-1));
    }
}
