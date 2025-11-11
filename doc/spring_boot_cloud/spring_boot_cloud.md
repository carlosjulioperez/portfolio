# SpringBoot Docker Kubernetes

- [SpringBoot Docker Kubernetes](#springboot-docker-kubernetes)
  - [Patterns](#patterns)
    - [Strangler Fig Pattern](#strangler-fig-pattern)
  - [DevTools](#devtools)
    - [sdkman](#sdkman)
      - [Java 17](#java-17)
      - [Maven](#maven)
      - [Docker](#docker)
    - [vscode](#vscode)
      - [Extensions](#extensions)
      - [Environment variables](#environment-variables)
    - [postman](#postman)
    - [IntelliJ IDEA](#intellij-idea)
      - [Keystrokes](#keystrokes)
  - [SpringBoot](#springboot)
    - [spring initializer](#spring-initializer)
      - [Dependencies](#dependencies)
    - [Configuration](#configuration)
      - [H2](#h2)
      - [Lombok](#lombok)
    - [Annotations](#annotations)
      - [@MappedSuperClass](#mappedsuperclass)
      - [Auto-Increment ID:](#auto-increment-id)
      - [GlobalExceptionHandler](#globalexceptionhandler)
    - [Project's packages](#projects-packages)
    - [API Documentation](#api-documentation)
      - [OpenAPI](#openapi)
      - [springdoc-openapi](#springdoc-openapi)
      - [Swagger](#swagger)

## Patterns
### Strangler Fig Pattern
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

## DevTools
### sdkman
SDKMAN is a tool that lets you easily install and manage Java, Maven, and other SDKs.
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
```
#### Java 17
```bash
sdk list java
sdk install java 17.0.16-amzn
sdk default java 17.0.16-amzn
java -version
```
#### Maven
```bash
sdk install maven
mvn -v
...
mvn clean install
...
mvn spring-boot:run
java -jar target/accounts-0.0.1-SNAPSHOT.jar
```

#### Docker
```bash
docker build . -t carper/accounts:s4
docker images
docker inspect <image_id> (3 or 4 characters)
docker run -p 8080:8080 carper/accounts:s4
docker run -d -p 8080:8080 carper/accounts:s4 (detached)
docker ps
docker ps -a
...
docker start <container_id>
docker stop <container_id>
```

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

### IntelliJ IDEA
#### Keystrokes
* Option F1 (⌥ + fn + F1) / 1 Project View (Select in Project View)
* ⌘ = U+2318
* ⌘ F12: File structure popup 

## SpringBoot
### spring initializer
* https://start.spring.io/
* Project: Maven, Language: Java, Spring Boot: 3.5.7
* Group: com.carper, Artifact/Name/Description: accounts/cards/loans, Package name: com.carper.accounts
* Packaging: Jar, Configuration: YAML, Java: 17 

#### Dependencies
* Spring Web
* H2 Database
* Spring Data JPA
* Spring Boot Actuator
* Spring Boot DevTools
* Lombok
* Validation

### Configuration
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

#### H2
* http://localhost:8080/h2-console
* JDBC URL: jdbc:h2:mem:testdb

#### Lombok
* Settings / Build, Execution, Deployment / Compiler / Annotation Processors / check "Enable annotation processing"

### Annotations
#### @MappedSuperClass
* In JPA (Jakarta Persistence API), @MappedSuperclass is used when you want to share common fields or mappings between multiple entity classes — but the superclass itself is not an entity (so it’s not mapped to a database table).

```java
package com.carper.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @ToString
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}
```

```java
package com.carper.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Accounts extends BaseEntity {

    @Id
    @Column(name="account_number")
    public Long accountNumber;

    @Column(name="customer_id")
    public Long customerId;

    @Column(name="account_type")
    public String accountType;

    @Column(name="branch_address")
    public String branchAddress;
}
```

#### Auto-Increment ID:
* An auto-increment ID is a database-generated unique identifier that increases automatically every time a new record is inserted.
* In a Spring Boot application using JPA (Java Persistence API) and Hibernate, you can configure an entity’s primary key to auto-increment automatically — meaning you don’t have to manually assign an ID before saving it.

```java
package com.carper.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    public Long customerId;

    public String name;

    public String email;

    @Column(name="mobile_number")
    public String mobileNumber;

}
```

#### GlobalExceptionHandler

* In Spring Boot (Java), @ControllerAdvice and @ExceptionHandler are powerful annotations used for global exception handling across your application. They let you centralize error handling logic instead of writing repetitive try-catch blocks in every controller.

1. **@ControllerAdvice** — Global Exception Handling<br>@ControllerAdvice is a specialized Spring annotation that allows you to handle exceptions across all controllers in one place.<br>You can think of it as an interceptor for exceptions thrown by controller methods.

  ```java
  @ControllerAdvice
  public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

      @ExceptionHandler(Exception.class)
      public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,
                                                                              WebRequest webRequest){
          ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                  webRequest.getDescription(false),
                  HttpStatus.INTERNAL_SERVER_ERROR,
                  exception.getMessage(),
                  LocalDateTime.now()
          );
          return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
      }

      @ExceptionHandler(ResourceNotFoundException.class)
      public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                                   WebRequest webRequest){
          ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
                  webRequest.getDescription(false),
                  HttpStatus.NOT_FOUND,
                  exception.getMessage(),
                  LocalDateTime.now()
          );
          return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
      }
  }
  ```
2. **@ExceptionHandler** — Handling Specific Exceptions<br>Inside a class annotated with @ControllerAdvice, you can use @ExceptionHandler to specify which exception(s) each method should handle.

  ```java
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public class ResourceNotFoundException extends RuntimeException {

      public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
          super(String.format("%s not found with given input data %s: '%s'", resourceName, fieldName, fieldValue));

      }
  }
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
                        ├── impl
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

### API Documentation
#### OpenAPI
* The [OpenAPI Specifications](https://www.openapis.org/) provide a formal standard for describing HTTP APIs.
* This allows people to understand how an API works, how a sequence of APIs work together, generate client code, create tests, apply design standards,

#### springdoc-openapi
* [springdoc-openapi](https://springdoc.org/) java library helps to automate the generation of API documentation using spring boot projects. springdoc-openapi works by examining an application at runtime to infer API semantics based on spring configurations, class structure and various annotations.

pom.xml:
```xml
   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.8.14</version>
   </dependency>
```

#### Swagger
* Swagger originally started as a framework for describing and documenting RESTful APIs. It included both:
  * A specification (how to describe an API)
  * A set of tools for generating documentation, code, and clients.
* Over time, the Swagger Specification was donated to the OpenAPI Initiative (under the Linux Foundation).

* That specification became what we now call OpenAPI Specification (OAS). So:
  * Swagger = Tools
  * OpenAPI = Specification

* Then, visit: http://localhost:8080/swagger-ui.html
