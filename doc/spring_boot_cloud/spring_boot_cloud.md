# Table of Contents
- [Table of Contents](#table-of-contents)
- [Patterns](#patterns)
  - [Strangler Fig Pattern](#strangler-fig-pattern)
- [SpringBoot Docker Kubernetes](#springboot-docker-kubernetes)
  - [IntelliJ IDEA](#intellij-idea)
  - [spring initializer](#spring-initializer)
  - [Dependencies](#dependencies)
  - [Configuration](#configuration)
    - [H2](#h2)
    - [Lombok](#lombok)
  - [Annotations](#annotations)
    - [Project's packages](#projects-packages)
  - [API Documentation](#api-documentation)
    - [OpenAPI](#openapi)
    - [springdoc-openapi](#springdoc-openapi)
    - [Swagger](#swagger)
  - [DevTools](#devtools)
    - [vscode](#vscode)
      - [Extensions](#extensions)
      - [Environment variables](#environment-variables)
    - [postman](#postman)
  - [Sample App](#sample-app)
    - [Code](#code)
    - [Request and Response Samples](#request-and-response-samples)
    - [Template Project Structure](#template-project-structure)

# Patterns
## Strangler Fig Pattern
* The Strangler Fig Pattern is a software design and migration pattern used to gradually replace or modernize a legacy system without completely rewriting it from scratch.

* The name comes from how a strangler fig tree grows around a host tree — it slowly replaces the old tree until only the new structure remains. Similarly, in software, you “wrap” the legacy system with new components and gradually move functionality from the old system to the new one.

![alt text](sfp1.png "Strangler Fig Tree")

**Incremental process**

1. The Strangler Fig pattern begins by introducing a façade (proxy) between the client app, the legacy system, and the new system. The façade acts as an intermediary. It allows the client app to interact with the legacy system and the new system. Initially, the façade routes most requests to the legacy system.

2. As the migration progresses, the façade incrementally shifts requests from the legacy system to the new system. With each iteration, you implement more pieces of functionality in the new system. This incremental approach gradually reduces the legacy system's responsibilities and expands the scope of the new system. The process is iterative. It allows the team to address complexities and dependencies in manageable stages. These stages help the system remain stable and functional.

3. After you migrate all of the functionality and there are no dependencies on the legacy system, you can decommission the legacy system. The façade routes all requests exclusively to the new system.

4. You remove the façade and reconfigure the client app to communicate directly with the new system. This step marks the completion of the migration.

![alt text](sfp2.png "Strangler Fig Tree")

**Simple Example (in Python)**
* Suppose you have a legacy system for handling user data, and you’re building a new microservice to replace it.

```python
# --- Legacy System ---
class LegacyUserService:
    def get_user(self, user_id):
        print("Fetching user from Legacy System...")
        return {"id": user_id, "name": "Alice (Legacy)"}

# --- New System ---
class NewUserService:
    def get_user(self, user_id):
        print("Fetching user from New System...")
        return {"id": user_id, "name": "Alice (New)"}

# --- Strangler Facade ---
class UserServiceFacade:
    def __init__(self):
        self.legacy_service = LegacyUserService()
        self.new_service = NewUserService()

    def get_user(self, user_id):
        # Gradual migration rule: use new service for user_id > 1000
        if user_id > 1000:
            return self.new_service.get_user(user_id)
        else:
            return self.legacy_service.get_user(user_id)

# --- Client Code ---
facade = UserServiceFacade()

print(facade.get_user(500))    # Uses legacy system
print(facade.get_user(1500))   # Uses new system
```

# SpringBoot Docker Kubernetes
## IntelliJ IDEA
* ⌘ es U+2318
* ⌘ F12: File structure popup 

## spring initializer
* https://start.spring.io/
* Project: Maven, Language: Java, Spring Boot: 3.5.7
* Group: com.carper, Artifact/Name/Description: accounts/cards/loans, Package name: com.carper.accounts
* Packaging: Jar, Configuration: YAML, Java: 17 

## Dependencies
* Spring Web
* H2 Database
* Spring Data JPA
* Spring Boot Actuator
* Spring Boot DevTools
* Lombok
* Validation

## Configuration
* Refactor rename application.properties -> applications.yaml
```YAML
server:
  port: 8080
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: sa
    password: ''
  h2:
    console:
      enabled: true
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
```

### H2
* http://localhost:8080/h2-console
* JDBC URL: jdbc:h2:mem:testdb

### Lombok
* Settings / Build, Execution, Deployment / Compiler / Annotation Processors / check "Enable annotation processing"
## Annotations
* MappedSuperClass
* Auto increment Ids:
```java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long customerId;
```

### Project's packages
* Folder structure:

```plaintext
src
└── main
    └── java
        └── com
            └── carper
                └── accounts
                    ├── audit
                    ├── constants
                    ├── controller
                    ├── dto
                    ├── entity
                    ├── exception
                    ├── mapper
                    ├── repository
                    ├── service
                    └── AccountsApplication
```
* If the packages don't follow the above folder structure, then you must use the commented following annotations in Main Class (AccountsApplication):

```java
package com.carper.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*@ComponentScans({ @ComponentScan("com.carper.accounts.controller") })
@EnableJpaRepositories("com.carper.accounts.repository")
@EntityScan("com.carper.accounts.model")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
    info = @Info(
        title = "Accounts microservice REST Api Documentation",
        description = "DemoBank microservice REST Api Documentation",
        version = "v1",
        contact = @Contact(
            name = "Carlos Pérez",
            email = "carlosjulioperez@gmail.com",
            url = "https://www.linkedin.com/in/carlosjulioperez/"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.linkedin.com/in/carlosjulioperez/"
        )
    ),
    externalDocs = @ExternalDocumentation(
        description = "DemoBank microservice REST Api Documentation",
        url = "https://www.linkedin.com/in/carlosjulioperez/"
    )
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
```

## API Documentation
### OpenAPI
* The [OpenAPI Specifications](https://www.openapis.org/) provide a formal standard for describing HTTP APIs.
* This allows people to understand how an API works, how a sequence of APIs work together, generate client code, create tests, apply design standards,

### springdoc-openapi
* [springdoc-openapi](https://springdoc.org/) java library helps to automate the generation of API documentation using spring boot projects. springdoc-openapi works by examining an application at runtime to infer API semantics based on spring configurations, class structure and various annotations.

pom.xml:
```xml
   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.8.14</version>
   </dependency>
```

### Swagger
* Swagger originally started as a framework for describing and documenting RESTful APIs. It included both:
  * A specification (how to describe an API)
  * A set of tools for generating documentation, code, and clients.
* Over time, the Swagger Specification was donated to the OpenAPI Initiative (under the Linux Foundation).

* That specification became what we now call OpenAPI Specification (OAS). So:
  * Swagger = Tools
  * OpenAPI = Specification

* Then, visit: http://localhost:8080/swagger-ui.html

## DevTools
### vscode
#### Extensions
* REST Client, vim, JSON Crack
#### Environment variables
.vscode/settings.json
```JSON
{
  "rest-client.environmentVariables": {
    "dev": {
      "ACCOUNTS_URL": "http://localhost:8080",
      "API_KEY": "dev-api-key"
    },
    "qa": {
      "ACCOUNTS_URL": "https://qa.example.com",
      "API_KEY": "qa-api-key"
    },
    "stg": {
      "ACCOUNTS_URL": "https://stg.example.com",
      "API_KEY": "stg-api-key"
    },
    "prd": {
      "ACCOUNTS_URL": "https://api.example.com",
      "API_KEY": "prd-api-key"
    }
  }
}
```
### postman
```bash
brew install --cask postman
```

## Sample App
### Code

**1. `Customer.java` (Entity Class)**

```java
package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private Long id;
    
    private String name;
    
    private String mobileNumber;
}
```

*Key elements:*

* **`@Entity`**: Indicates this class is a JPA entity.
* **`@Id`**: Marks the `id` field as the primary key for the entity.
* **`@Data`**: Lombok annotation that generates getters, setters, and other utility methods.
* **`@NoArgsConstructor`** and **`@AllArgsConstructor`**: Lombok annotations that generate constructors.

---

**2. `CustomerRepository.java` (Repository Interface)**

```java
package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByMobileNumber(String mobileNumber);
}
```

*Key elements:*

* **`extends JpaRepository<Customer, Long>`**: Inherits CRUD operations for `Customer` entities.
* **`findByMobileNumber(String mobileNumber)`**: Custom query method to find a customer by their mobile number.

---

**3. `CustomerDto.java` (DTO Class)**

```java
package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {

    private Long id;
    
    private String name;
    
    private String mobileNumber;
}
```

*Key elements:*

* **`@Data`**: Lombok annotation that generates getters, setters, and other utility methods.
* **`@AllArgsConstructor`**: Lombok annotation that generates a constructor with all fields.

---

**4. `CustomerMapper.java` (Mapper Class)**

```java
package com.example.demo.mapper;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(customer.getId(), customer.getName(), customer.getMobileNumber());
    }

    public Customer toCustomer(CustomerDto customerDto) {
        return new Customer(customerDto.getId(), customerDto.getName(), customerDto.getMobileNumber());
    }
}
```

*Key elements:*

* **`@Component`**: Marks the class as a Spring-managed bean.
* **`toCustomerDto(Customer customer)`**: Converts a `Customer` entity into a `CustomerDto`.
* **`toCustomer(CustomerDto customerDto)`**: Converts a `CustomerDto` back into a `Customer` entity.

---

**5. `IService.java` (Service Interface)**

```java
package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface IService {

    ResponseEntity<CustomerDto> getCustomerByMobileNumber(String mobileNumber);

    ResponseEntity<ResponseDto> createCustomer(CustomerDto customerDto);
}
```

*Key elements:*

* **Method Declarations**: The interface declares methods such as `getCustomerByMobileNumber` and `createCustomer`, which will be implemented in the service layer.

---

**6. `CustomerServiceImpl.java` (Service Implementation)**

```java
package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.IService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements IService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomerByMobileNumber(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        
        CustomerDto customerDto = customerMapper.toCustomerDto(customer);
        return ResponseEntity.ok(customerDto);
    }

    @Override
    public ResponseEntity<ResponseDto> createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toCustomer(customerDto);
        customer = customerRepository.save(customer);
        
        ResponseDto response = new ResponseDto("200", "Customer created successfully");
        return ResponseEntity.ok(response);
    }
}
```

*Key elements:*

* **`@Service`**: Marks the class as a Spring service.
* **`@Autowired`**: Injects the required dependencies (`CustomerRepository` and `CustomerMapper`).
* **`getCustomerByMobileNumber`**: Fetches a customer by mobile number and maps it to `CustomerDto`.
* **`createCustomer`**: Converts `CustomerDto` to `Customer`, saves it in the database, and returns a `ResponseDto`.

---

**7. `CustomerController.java` (Controller Class)**

```java
package com.example.demo.controller;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CustomerController {

    private final IService customerService;

    @GetMapping("/customer/{mobileNumber}")
    public ResponseEntity<CustomerDto> getCustomerByMobileNumber(@PathVariable String mobileNumber) {
        return customerService.getCustomerByMobileNumber(mobileNumber);
    }

    @PostMapping("/customer")
    public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }
}
```

*Key elements:*

* **`@RestController`**: Specifies the class as a Spring REST controller.
* **`@AllArgsConstructor`**: Lombok annotation to generate a constructor for injecting `IService`.
* **`@GetMapping`** and **`@PostMapping`**: Handle GET and POST requests for retrieving and creating customers, respectively.

---

**8. `ResponseDto.java` (Custom Response Class)**

```java
package com.example.demo.dto;

import lombok.Data;

@Data
public class ResponseDto {

    private String statusCode;
    private String statusMsg;

    public ResponseDto(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
```

*Key elements:*

* **`statusCode`**: A string representing the status code of the operation.
* **`statusMsg`**: A string providing a human-readable message of the operation status.
* **`@Data`**: Lombok annotation that generates getters, setters, `toString()`, `equals()`, and `hashCode()` methods.

---

**9. `ErrorResponseDto.java` (Error Response DTO)**

```java
package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ErrorResponseDto {

    private LocalDateTime timestamp;
    private String status;
    private String error;
    private String message;
    private String path;

    public ErrorResponseDto(String status, String error, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
```

*Key elements:*

* **`timestamp`**: The time when the error occurred.
* **`status`**: The HTTP status (e.g., "404").
* **`error`**: A brief error description.
* **`message`**: A detailed error message.
* **`path`**: The path of the request that caused the error.

---

**10. `GlobalExceptionHandler.java` (Global Exception Handler)**

```java
package com.example.demo.handler;

import com.example.demo.dto.ErrorResponseDto;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponseDto errorResponse = new ErrorResponseDto(
            HttpStatus.NOT_FOUND.toString(),
            "Not Found",
            ex.getMessage(),
            ex.getLocalizedMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
```

*Key elements:*
- **`@RestControllerAdvice`**: Provides global exception handling for controllers.
- **`@ExceptionHandler`**: Catches specific exceptions (like `ResourceNotFoundException`) and returns a custom error response.

---

**11. `ResourceNotFoundException.java` (Custom Exception)**

```java
package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s: '%s'", resourceName, fieldName, fieldValue));
    }
}
```

*Key elements:*

* **Custom exception** that provides detailed error messages when a resource (e.g., `Customer`) is not found.

---

**12. `Application.java` (Main Application Class)**

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

*Key elements:*

* **`@SpringBootApplication`**: Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan` annotations to start the application.
* **`main()`**: The entry point of the Spring Boot application.

---

### Request and Response Samples

1. **Create Customer (POST request)**

   * **Request Body (JSON)**:

   ```json
   {
     "id": 1,
     "name": "John Doe",
     "mobileNumber": "1234567890"
   }
   ```

   * **Response Body (JSON)**:

   ```json
   {
     "statusCode": "200",
     "statusMsg": "Customer created successfully"
   }
   ```

2. **Get Customer by Mobile Number (GET request)**

   * **Request URL**: `GET /api/customer/1234567890`

   * **Response Body (JSON)**:

   ```json
   {
     "id": 1,
     "name": "John Doe",
     "mobileNumber": "1234567890"
   }
   ```

3. **Error Response (Resource Not Found)**

   * **When a customer is not found** (e.g., if you try to get a customer with a non-existing mobile number).

   * **Response Body (JSON)**:

   ```json
   {
     "timestamp": "2025-11-04T12:34:56",
     "status": "404",
     "error": "Not Found",
     "message": "Customer not found with mobileNumber: '9876543210'",
     "path": "/api/customer/9876543210"
   }
   ```

---

### Template Project Structure

Here is the template of directory structure for the project:

```plaintext
src/
 ├── main/
 │    ├── java/
 │    │    └── com/
 │    │         └── example/
 │    │              └── demo/
 │    │                   ├── Application.java
 │    │                   ├── controller/
 │    │                   │    └── CustomerController.java
 │    │                   ├── dto/
 │    │                   │    ├── CustomerDto.java
 │    │                   │    ├── ErrorResponseDto.java
 │    │                   │    ├── ResponseDto.java
 │    │                   ├── exception/
 │    │                   │    └── ResourceNotFoundException.java
 │    │                   ├── handler/
 │    │                   │    └── GlobalExceptionHandler.java
 │    │                   ├── mapper/
 │    │                   │    └── CustomerMapper.java
 │    │                   ├── model/
 │    │                   │    └── Customer.java
 │    │                   ├── repository/
 │    │                   │    └── CustomerRepository.java
 │    │                   └── service/
 │    │                        ├── IService.java
 │    │                        └── impl/
 │    │                             └── CustomerServiceImpl.java
 └── resources/
      ├── application.yaml
```

---

*Explanation of the Structure*:

1. **`src/main/java/com/example/demo`**: The root package of the application.

   * **`Application.java`**: The main Spring Boot application class that launches the application.

   * **`controller/CustomerController.java`**: The REST controller that handles HTTP requests related to customers.

   * **`dto/`**: Contains Data Transfer Object (DTO) classes:

     * **`CustomerDto.java`**: Represents the customer data to be transferred.
     * **`ResponseDto.java`**: Represents a standard response object for all operations.
     * **`ErrorResponseDto.java`**: Represents the error response with detailed information like timestamp and status code.

   * **`exception/ResourceNotFoundException.java`**: A custom exception thrown when a resource (like a `Customer`) is not found.

   * **`handler/GlobalExceptionHandler.java`**: Global exception handler that catches exceptions like `ResourceNotFoundException` and returns custom error responses.

   * **`mapper/CustomerMapper.java`**: A utility class to convert between the `Customer` entity and the `CustomerDto`.

   * **`model/Customer.java`**: The entity class that represents the `Customer` table in the database.

   * **`repository/CustomerRepository.java`**: Interface for database access, extending `JpaRepository` to handle CRUD operations on the `Customer` entity.

   * **`service/IService.java`**: Interface that defines the business methods for customer operations (like `getCustomerByMobileNumber` and `createCustomer`).

   * **`service/impl/CustomerServiceImpl.java`**: The service implementation that contains the business logic for customer operations.

2. **`src/main/resources/`**: Contains configuration files, such as `application.yaml` where you define application-specific settings (e.g., database connection, server ports).

---