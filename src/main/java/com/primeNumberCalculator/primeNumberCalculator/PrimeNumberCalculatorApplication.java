package com.primeNumberCalculator.primeNumberCalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The main entry point for the Prime Number Calculator application.
 * This class is responsible for bootstrapping the Spring Boot application
 * and enabling caching functionality.
 */
@SpringBootApplication // Indicates that this is a Spring Boot application
@EnableCaching // Enables caching support in the application
public class PrimeNumberCalculatorApplication {

	/**
	 * The main method that runs the application.
	 *
	 * @param args Command-line arguments passed during application startup
	 */
	public static void main(String[] args) {
		SpringApplication.run(PrimeNumberCalculatorApplication.class, args);
	}

}
