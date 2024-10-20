package com.primeNumberCalculator.primeNumberCalculator.controller;

import com.primeNumberCalculator.primeNumberCalculator.model.Outcome;
import com.primeNumberCalculator.primeNumberCalculator.model.PrimeNumberCalculatorOutcome;
import com.primeNumberCalculator.primeNumberCalculator.service.PrimeNumberCalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Test class for the PrimeNumberCalculatorController.
 * This class tests the behavior of the controller using Mockito to mock
 * the service layer.
 */
class PrimeNumberCalculatorControllerTest {

    @InjectMocks
    private PrimeNumberCalculatorController controller;

    @Mock
    private PrimeNumberCalculatorService primeNumberCalculatorService;

    /**
     * Initializes the mocks before each test.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test for retrieving prime numbers with a positive input.
     */
    @Test
    void testGetPrimes_WithPositiveNumber() {
        int number = 10;
        List<Integer> expectedPrimes = Arrays.asList(2, 3, 5, 7);
        PrimeNumberCalculatorOutcome expectedResponseData = new PrimeNumberCalculatorOutcome(expectedPrimes);
        Outcome<PrimeNumberCalculatorOutcome > expectedOutcome = new Outcome<>(true, "Success", expectedResponseData);

        when(primeNumberCalculatorService.primesUpTo(number)).thenReturn(expectedPrimes);

        ResponseEntity<Outcome<PrimeNumberCalculatorOutcome >> response = controller.getPrimes(number);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedOutcome.isSuccess(), response.getBody().isSuccess());
        assertEquals(expectedOutcome.getMessage(), response.getBody().getMessage());
        assertEquals(expectedResponseData.getPrimeNumbers(), response.getBody().getData().getPrimeNumbers());
    }

    /**
     * Test for retrieving prime numbers with zero as input.
     */
    @Test
    void testGetPrimes_WithZero() {
        int number = 0;
        List<Integer> expectedPrimes = Arrays.asList();
        PrimeNumberCalculatorOutcome  expectedResponseData = new PrimeNumberCalculatorOutcome(expectedPrimes);
        Outcome<PrimeNumberCalculatorOutcome > expectedOutcome = new Outcome<>(true, "Success", expectedResponseData);

        when(primeNumberCalculatorService.primesUpTo(number)).thenReturn(expectedPrimes);

        ResponseEntity<Outcome<PrimeNumberCalculatorOutcome>> response = controller.getPrimes(number);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedOutcome.isSuccess(), response.getBody().isSuccess());
        assertEquals(expectedOutcome.getMessage(), response.getBody().getMessage());
        assertEquals(expectedResponseData.getPrimeNumbers(), response.getBody().getData().getPrimeNumbers());
    }

    /**
     * Test for retrieving prime numbers with a negative input.
     */
    @Test
    void testGetPrimes_WithNegativeNumber() {
        int number = -5;
        List<Integer> expectedPrimes = Arrays.asList();
        PrimeNumberCalculatorOutcome expectedResponseData = new PrimeNumberCalculatorOutcome(expectedPrimes);
        Outcome<PrimeNumberCalculatorOutcome> expectedOutcome = new Outcome<>(true, "Success", expectedResponseData);

        when(primeNumberCalculatorService.primesUpTo(number)).thenReturn(expectedPrimes);

        ResponseEntity<Outcome<PrimeNumberCalculatorOutcome>> response = controller.getPrimes(number);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedOutcome.isSuccess(), response.getBody().isSuccess());
        assertEquals(expectedOutcome.getMessage(), response.getBody().getMessage());
        assertEquals(expectedResponseData.getPrimeNumbers(), response.getBody().getData().getPrimeNumbers());
    }
}
