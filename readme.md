# Prime Number Calculator

## Overview

The Prime Number Calculator is a Spring Boot application that provides an API for calculating prime numbers up to a specified integer. It features caching to improve performance and supports multiple response formats, including JSON and XML.

## Features

- **Calculate Prime Numbers**: Retrieve all prime numbers up to a specified integer.
- **Caching**: Uses caching to improve response times for frequently requested calculations.
- **Multiple Media Types**: Supports responses in both JSON and XML formats.
- **Integration Testing**: Uses Karate for API endpoints and JUnit for unit tests.

## Technologies Used

- Java 17
- Spring Boot
- Maven
- JUnit & Mockito (for unit testing)
- Karate (for integration testing)

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven
- An IDE like IntelliJ IDEA

### Installation

1. **Clone the Repository:**

   ``` 
   git clone https://github.com/Claireh248/prime-number-calculator.git
   cd prime-number-calculator 
   ```

2. **Build the Project:** <br>
   Use Maven to build the project:

   ``` 
   mvn clean install
   ```

2. **Run the Application:**

   You can run the application using:

   ```
   mvn spring-boot:run
   ```

   The application will start on http://localhost:8080.

### API Endpoints

#### Get Prime Numbers Endpoint: 
   **GET /primes/{number}**  <br>
   Description: Returns a list of prime numbers up to the specified number. <br>
   Response Formats: JSON, XML

#### Example Requests

Curl command XML
```
curl -H "Accept: application/xml" http://localhost:8080/primes/10
```

Curl command JSON
```
curl -H "Accept: application/json" http://localhost:8080/primes/10
```

**JSON Response** <br>
Request: http://localhost:8080/primes/10 <br>
Headers: Accept - application/json
```
{
    "success": true,
    "message": "Success",
    "data": {
        "primeNumbers": [
            2,
            3,
            5,
            7
        ]
    }
}
```


**XML Response** <br>
Request: http://localhost:8080/primes/10 <br>
Headers: Accept - application/xml
```
<Outcome>
    <success>true</success>
    <message>Success</message>
    <data>
        <primeNumbers>
            <primeNumbers>2</primeNumbers>
            <primeNumbers>3</primeNumbers>
            <primeNumbers>5</primeNumbers>
            <primeNumbers>7</primeNumbers>
        </primeNumbers>
    </data>
</Outcome>
```

### Hosting on AWS EC2

The application is hosted on AWS EC2. You can access it at the following link:


Examples of the above requests are as follows - if using Postman or curl command, Accept headers will be required. <br>
**If pasting into a browser the application will default to XML response.** <br>

http://ec2-3-248-223-114.eu-west-1.compute.amazonaws.com:8080/primes/10

**Curl command JSON**
```
curl -H "Accept: application/json" http://ec2-3-248-223-114.eu-west-1.compute.amazonaws.com:8080/primes/10
```
Response:

```
{
    "success": true,
    "message": "Success",
    "data": {
        "primeNumbers": [
            2,
            3,
            5,
            7
        ]
    }
}
```

**Curl command XML**
```
curl -H "Accept: application/xml" http://ec2-3-248-223-114.eu-west-1.compute.amazonaws.com:8080/primes/10
```

Response: 
```
<Outcome>
    <success>true</success>
    <message>Success</message>
    <data>
        <primeNumbers>
            <primeNumbers>2</primeNumbers>
            <primeNumbers>3</primeNumbers>
            <primeNumbers>5</primeNumbers>
            <primeNumbers>7</primeNumbers>
        </primeNumbers>
    </data>
</Outcome>
```

Postman requests can be done as listed in previous section, replacing localhost link with EC2 DNS. 

### Testing

**Unit Tests** <br>
Run unit tests using:
```
mvn test
```
**Integration Tests** <br>
Karate integration tests can be run using:

```
mvn test -Dtest=KarateTest
```

Note that when testing the application there can be no running instances of the application locally. This is as both are configured to use port 8080.

### Code Coverage

To check code coverage, run your tests with coverage in your IDE (e.g., IntelliJ IDEA). 

### Future Improvements

- Cache uses Spring Boots auto-configured cache included in the starter dependency. This could lead to future problems such as heap memory being filled - to overcome this for now, I have deployed the application with -Xms1024m -Xmx2048m parameters to increase the heap memory. A better long term solution would be to use another cache library to set up cache expiry, where cached data is cleared after a certain time period.
- The application currently only supports JSON and XML response types - this could be expanded to others such as csv. When sending requests via browser where no headers are added it defaults to XML, so implementation of supporting JSON and XML should be amended to resolve this.
- The application uses a single algorithm to calculate the prime numbers up to the given number - other algorithms could be used and possibly improve performance of the application, or be used via different endpoints.