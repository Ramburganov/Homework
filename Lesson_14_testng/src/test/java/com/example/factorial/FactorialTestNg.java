package com.example.factorial;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.math.BigInteger;

public class FactorialTestNg {

    @Test
    public void testFactorialPositive() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(com.example.factorial.Factorial.calculateFactorial(5), BigInteger.valueOf(120), "Factorial of 5 should be 120");
        softAssert.assertEquals(com.example.factorial.Factorial.calculateFactorial(0), BigInteger.ONE, "Factorial of 0 should be 1");
        softAssert.assertEquals(com.example.factorial.Factorial.calculateFactorial(1), BigInteger.ONE, "Factorial of 1 should be 1");

        // Сообщаем TestNG, что все проверки прошли успешно
        softAssert.assertAll();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        com.example.factorial.Factorial.calculateFactorial(-1);
    }
}
