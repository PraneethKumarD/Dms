package com.cye.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "DMS",
        version = "1.0",
        description = "API documentation for the DMS using Spring Boot.",
        contact = @Contact(
            name = "Praneeth Kumar", 
            email = "praneethpk7@gmail.com",
            url = "https://www.amazon.in"
        ),
        license = @License(
            name = "MIT", 
            url = "https://opensource.org/licenses/MIT"
        )
    )
) 
public class DmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmsApplication.class, args);
	}

}
