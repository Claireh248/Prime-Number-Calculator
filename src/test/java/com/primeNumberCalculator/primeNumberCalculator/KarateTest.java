package com.primeNumberCalculator.primeNumberCalculator;

import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for running Karate integration tests.
 * This class is used to execute feature files that define
 * the behavior of the application using the Karate framework.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = "server.port=8080")
class KarateTest {

    /**
     * Runs all Karate tests defined in the feature file primeNumberCalculator in test/resources.
     *
     * @return a Karate test instance to run the feature tests in primeNumberCalculator.feature
     */
    @Karate.Test
    Karate testAll() {
        return Karate.run("classpath:primeNumberCalculator.feature").relativeTo(getClass());
    }
}
