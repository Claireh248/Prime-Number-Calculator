package com.primeNumberCalculator.primeNumberCalculator.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/**
 * Service for calculating prime numbers.
 */
@Service
public class PrimeNumberCalculatorService {

    /**
     * Calculates all prime numbers up to a given number.
     * This method is cacheable, meaning results will be stored
     * for subsequent calls with the same parameter to improve performance.
     *
     * @param givenNumber the upper limit for calculating prime numbers - provided in request
     * @return a list of prime numbers up to the given number
     */
    @Cacheable("primesCache")
    public List<Integer> primesUpTo(int givenNumber){
        List<Integer> primeNumbers = new ArrayList<>();

        for(int i = 0; i <=givenNumber; i++){
            if (isPrime(i)){
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    /**
     * Determines if a number is prime.
     *
     * @param n the number to check
     * @return true if the number is prime, false otherwise
     */
    public Boolean isPrime(int n){
        if ( n < 2 ){
            return false; // numbers < 2 are not a prime number
        }
        for (int i = 2; i <= Math.sqrt(n); i++){ // using sqrt to reduce search
            if (n % i == 0){
                return false; //divisor found, is not a prime number
            }
        }
        return true; // no divisors found, is a prime number
    }
}
