package com.primeNumberCalculator.primeNumberCalculator.controller;

import com.primeNumberCalculator.primeNumberCalculator.model.Outcome;
import com.primeNumberCalculator.primeNumberCalculator.model.PrimeNumberCalculatorOutcome;
import com.primeNumberCalculator.primeNumberCalculator.service.PrimeNumberCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling requests related to prime number calculations.
 */
@RestController
public class PrimeNumberCalculatorController {

    @Autowired
    PrimeNumberCalculatorService primeNumberCalculatorService;

    /**
     * Handles GET requests to retrieve prime numbers up to a specified number.
     * Supports XML and JSON responses
     *
     * @param number the upper limit for calculating prime numbers
     * @return a ResponseEntity containing the outcome of the operation, including the list of prime numbers
     */
    @GetMapping(value = "/primes/{number}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Outcome<PrimeNumberCalculatorOutcome>> getPrimes(@PathVariable int number) {

        PrimeNumberCalculatorOutcome primeNumberData = new PrimeNumberCalculatorOutcome(primeNumberCalculatorService.primesUpTo(number));
        Outcome<PrimeNumberCalculatorOutcome> outcome = new Outcome<>(true, "Success", primeNumberData);
        return ResponseEntity.ok(outcome);

    }
}
