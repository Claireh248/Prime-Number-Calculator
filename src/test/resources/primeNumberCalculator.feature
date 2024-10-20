Feature: Prime Number Calculator API
  # This feature tests the Prime Number Calculator API endpoints
  # for retrieving prime numbers based on a given number.
  # The feature file is for a local instance of the application -
  # as uses same port, make sure there are no existing instances of the application
  #before running test.

  Scenario: Get prime numbers up to a positive integer
    # Test case to retrieve prime numbers up to the integer 10.
    Given url 'http://localhost:8080/primes/10'
    When method get
    Then status 200
    And match response.success == true
    And match response.message == 'Success'
    And match response.data.primeNumbers == [2, 3, 5, 7]

  Scenario: Get prime numbers when the input is zero
    # Test case to verify that an input of 0 returns an empty list of prime numbers.
    Given url 'http://localhost:8080/primes/0'
    When method get
    Then status 200
    And match response.success == true
    And match response.message == 'Success'
    And match response.data.primeNumbers == []

  Scenario: Get prime numbers when the input is a negative integer
    # Test case to verify that an input of a negative integer returns an empty list of prime numbers.
    Given url 'http://localhost:8080/primes/-5'
    When method get
    Then status 200
    And match response.success == true
    And match response.message == 'Success'
    And match response.data.primeNumbers == []
