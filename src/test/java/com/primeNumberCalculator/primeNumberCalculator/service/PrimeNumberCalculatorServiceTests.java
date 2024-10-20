package com.primeNumberCalculator.primeNumberCalculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the PrimeNumberCalculatorService.
 * This class tests the logic for calculating prime numbers.
 */
@SpringBootTest
public class PrimeNumberCalculatorServiceTests {
    private final PrimeNumberCalculatorService primeNumberCalculatorService = new PrimeNumberCalculatorService();

    /**
     * Test for calculating prime numbers up to a positive number.
     */
    @Test
    void testPrimesUpTo_PositiveNumber() {
        int number = 10;
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);

        List<Integer> actualPrimes = primeNumberCalculatorService.primesUpTo(number);

        assertEquals(expectedPrimes, actualPrimes);
    }

    /**
     * Test for calculating prime numbers with zero as input.
     */
    @Test
    void testPrimesUpTo_Zero() {
        int number = 0;
        List<Integer> expectedPrimes = Arrays.asList();

        List<Integer> actualPrimes = primeNumberCalculatorService.primesUpTo(number);

        assertEquals(expectedPrimes, actualPrimes);
    }

    /**
     * Test for calculating prime numbers with a negative input.
     */
    @Test
    void testPrimesUpTo_NegativeNumber() {
        int number = -5;
        List<Integer> expectedPrimes = Arrays.asList();

        List<Integer> actualPrimes = primeNumberCalculatorService.primesUpTo(number);

        assertEquals(expectedPrimes, actualPrimes);
    }

    /**
     * Test for verifying prime numbers for known prime values.
     */
    @Test
    void testIsPrime_ValidPrimes() {
        assertEquals(true, primeNumberCalculatorService.isPrime(2));
        assertEquals(true, primeNumberCalculatorService.isPrime(3));
        assertEquals(true, primeNumberCalculatorService.isPrime(5));
        assertEquals(true, primeNumberCalculatorService.isPrime(7));
    }

    /**
     * Test for verifying non-prime values.
     */
    @Test
    void testIsPrime_ValidNonPrimes() {
        assertEquals(false, primeNumberCalculatorService.isPrime(1));
        assertEquals(false, primeNumberCalculatorService.isPrime(4));
        assertEquals(false, primeNumberCalculatorService.isPrime(6));
        assertEquals(false, primeNumberCalculatorService.isPrime(9));
    }

    /**
     * Test for verifying that negative numbers are not prime.
     */
    @Test
    void testIsPrime_NegativeNumbers() {
        assertEquals(false, primeNumberCalculatorService.isPrime(-1));
        assertEquals(false, primeNumberCalculatorService.isPrime(-5));
    }

    /**
     * Test for verifying that zero is not prime.
     */
    @Test
    void testIsPrime_Zero() {
        assertEquals(false, primeNumberCalculatorService.isPrime(0));
    }

}
