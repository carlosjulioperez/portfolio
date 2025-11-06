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
