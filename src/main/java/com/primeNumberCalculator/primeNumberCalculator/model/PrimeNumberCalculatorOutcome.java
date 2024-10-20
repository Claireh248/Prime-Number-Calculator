package com.primeNumberCalculator.primeNumberCalculator.model;

import java.util.List;

/**
 * Represents the response structure for prime number calculations.
 * This class is used to encapsulate the list of prime numbers
 * returned by the PrimeNumberCalculatorController.
 */
public class PrimeNumberCalculatorOutcome {
    private List<Integer> primeNumbers;

    /**
     * Constructs a new PrimeNumberCalculatorOutcome  with the specified list of prime numbers.
     *
     * @param primeNumbers a list of prime numbers
     */
    public PrimeNumberCalculatorOutcome(List<Integer> primeNumbers) {
        this.primeNumbers = primeNumbers;
    }

    /**
     * Retrieves the list of prime numbers.
     *
     * @return a list of prime numbers
     */
    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }
}
